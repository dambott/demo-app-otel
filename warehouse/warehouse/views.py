import random
import sys
import time
import traceback
import requests
import logging
import resource

from concurrent.futures import ThreadPoolExecutor
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.conf import settings


from opentelemetry import trace
from opentelemetry.propagate import inject
from opentelemetry.exporter.otlp.proto.grpc.trace_exporter import OTLPSpanExporter
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor
from opentelemetry.trace import set_span_in_context
from opentelemetry.sdk.resources import SERVICE_NAME, Resource

resource = settings.RESOURCE
logging.basicConfig(level=logging.INFO)
log = logging.getLogger(__name__)
log.debug("views running")
log.debug("test: %s", "string")

# Configure the tracer to export traces to OTLP GRPC

#otlp_exporter = OTLPSpanExporter(endpoint="http://tacocat-wavefront-proxy:4317", insecure=True)

cfgStr = "%s:%s" % (settings.PROXYHOST, settings.PROXYTRACINGPORT)
log.debug("cfgStr:%s", cfgStr)
print("%s",cfgStr)
#otlp_exporter = OTLPSpanExporter(endpoint="http://tanzu-observability-demo-wavefront-proxy:4317", insecure=True)
otlp_exporter = OTLPSpanExporter(endpoint=cfgStr, insecure=True)


tracer_provider = TracerProvider(resource=resource)
trace.set_tracer_provider(tracer_provider)
span_processor = BatchSpanProcessor(otlp_exporter)
tracer_provider.add_span_processor(span_processor)

#opentracing_tracer = opentracing_shim.create_tracer(tracer_provider)

tracer = trace.get_tracer_provider().get_tracer(__name__)
#set_resource_labels(tracer)


executor = ThreadPoolExecutor(max_workers=2)

vinfo = sys.implementation.version
result =  ".".join(map(
    str,
    vinfo[:3]
    if vinfo.releaselevel == "final" and not vinfo.serial
    else vinfo
))

@api_view(http_method_names=["GET"])
def fetch(request, order_num):
    try:
        time.sleep(1)
        if random.randint(1, 1000) == 1000:
            raise RuntimeError("Random Service Unavailable!")
        if not order_num:
            raise ValueError("Invalid Order Num!")

        # Trying to inherit parent span
#        carrier = {}
#        ctx = TraceContextTextMapPropagator().extract(carrier=carrier)
#        context.attach(ctx)
#        cspan = trace.get_current_span()
        tracer.start_as_current_span('start fetch')
        cspan = trace.get_current_span()

        executor.submit(async_fetch, cspan)
        if random.randint(1, 3) == 3:
            requests.get(
                "http://localhost:" + request.META["SERVER_PORT"] + "/check_stock")
        return Response(
            data={"status": "Order:" + order_num + " fetched from warehouse"},
            status=202)
    except RuntimeError:
        return handle_exception(cspan, sys.exc_info(), 503)
    except ValueError:
        return handle_exception(cspan, sys.exc_info(), 400)


def async_fetch(parent_span):
        context = set_span_in_context(parent_span)
        with tracer.start_as_current_span('async_fetch',context=context) as scope:
#        with tracer.start_as_current_span('async_fetch') as scope:
#        with trace.get_current_span() as scope:
            try:
                time.sleep(0.5)
                if random.randint(1, 1000) == 1000:
                    raise RuntimeError("Fail to execute async_fetch")
                invoke_lambda(trace.get_current_span())
                return
            except RuntimeError:
                handle_exception(scope, sys.exc_info())

def invoke_lambda(parent_span):
        context = set_span_in_context(parent_span)
        with tracer.start_as_current_span('invoke_lambda',context=context):
#        with tracer.start_as_current_span('invoke_lambda'):
            cspan = trace.get_current_span()
            cspan.set_attribute("span.kind", "client")
            cspan.set_attribute("component", "java-aws-sdk")
            cspan.set_attribute("peer.service", "AWSLambda")
            try:
                time.sleep(1.5)
                if random.randint(1, 1000) == 1000:
                    raise RuntimeError("Fail to invoke lambda")
                    return
            except RuntimeError:
                handle_exception(cspan, sys.exc_info())


@api_view(http_method_names=["GET"])
def check_stock(request):
    time.sleep(1)
    schedule_checking(tracer.start_as_current_span("check_stock"))
#    schedule_checking(trace.get_current_span())
    return Response(status=202)


def schedule_checking(parent_span):
#    context = set_span_in_context(parent_span)
#    context = trace.get_current_span().get_span_context()

#    link_from_current = trace.Link(ctx)
#    with tracer.start_as_current_span('schedule_checking',context=context) as scope:
    with tracer.start_as_current_span('schedule_checking') as scope:
#    with trace.get_current_span() as scope:
        time.sleep(1)
        executor.submit(async_check, scope)
        return


def async_check(parent_span):
#    context = set_span_in_context(parent_span)
    with tracer.start_as_current_span('async_check'):
#    with trace.get_current_span() :
        time.sleep(1)
        return


def handle_exception(active_span, exe_info, status_code=None):
    error_msg = str(exe_info[1])
    if error_msg:
        logging.warning(error_msg)
    if active_span:
        active_span.set_tag('error', 'true')
        error_log = {
            'ErrorType': str(exe_info[0].__name__),
            'ErrorContent': error_msg,
            'ErrorTraceBack':
                '\n'.join(map(str.strip, traceback.format_tb(exe_info[2])))}
        print(error_log)
        active_span.set_status(StatusCode.ERROR)
        active_span.set_attribute("error","true")
        active_span.record_exception(exe_info)
#        active_span.log_kv(error_log)
    if not status_code:
        return
    else:
        return Response(error_msg, status=status_code)
