package internal

import (
	"context"
	"fmt"
	"go.opentelemetry.io/otel"
	"go.opentelemetry.io/otel/attribute"
	"go.opentelemetry.io/otel/exporters/otlp/otlptrace/otlptracegrpc"
	"go.opentelemetry.io/otel/exporters/stdout/stdouttrace"
	"go.opentelemetry.io/otel/propagation"
	"go.opentelemetry.io/otel/sdk/resource"
	sdktrace "go.opentelemetry.io/otel/sdk/trace"
	semconv "go.opentelemetry.io/otel/semconv/v1.10.0"
	"go.opentelemetry.io/otel/trace"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"io"
	"io/ioutil"
	"log"
	"net/http"
	"strings"
)

const name = "inventory"

var Gtrace trace.Tracer

// newResource returns a resource describing this application.
func newResource() *resource.Resource {
	r := resource.NewWithAttributes(
		semconv.SchemaURL,
		attribute.String("source", GlobalConfig.Source),
		attribute.String("cluster", GlobalConfig.Cluster),
		attribute.String("shard", GlobalConfig.Shard),
		attribute.String("application", GlobalConfig.Application),
		semconv.ServiceNameKey.String(GlobalConfig.Service),
	)
	return r
}

// formatRequest generates ascii representation of a request
func formatRequest(r *http.Request) string {
	// Create return string
	var request []string
	// Add the request string
	url := fmt.Sprintf("%v %v %v", r.Method, r.URL, r.Proto)
	request = append(request, url)
	// Add the host
	request = append(request, fmt.Sprintf("Host: %v", r.Host))
	// Loop through headers
	for name, headers := range r.Header {
		name = strings.ToLower(name)
		for _, h := range headers {
			request = append(request, fmt.Sprintf("v: %v", name, h))

		}
	}

	// If this is a POST, add post data
	if r.Method == "POST" {
		r.ParseForm()
		request = append(request, "\n")
		request = append(request, r.Form.Encode())
	}
	// Return the request as a string
	return strings.Join(request, "\n")
}

// stdout tracer for debugging
func NewStdoutTracer() io.Closer {
	var err error
	var tags = newResource()

	exp, err := stdouttrace.New(stdouttrace.WithPrettyPrint()) // for debugging
	if err != nil {
		log.Panicf("failed to initialize stdouttrace exporter %v\n", err)
		return ioutil.NopCloser(nil)
	}

	ssp := sdktrace.NewSimpleSpanProcessor(exp)
	tp := sdktrace.NewTracerProvider(
		sdktrace.WithResource(tags),
		sdktrace.WithSpanProcessor(ssp),
	)
	otel.SetTracerProvider(tp)
	Gtrace = otel.Tracer(name)
	return ioutil.NopCloser(nil)
}

func NewGlobalTracer(serviceName string) io.Closer {

	var tags = newResource()

	log.Printf("NewGlobalTracer: 1")
	log.Printf("Tags: application %s service %s", GlobalConfig.Application, GlobalConfig.Service)
	//otlpHost := fmt.Sprintf("http://%s:%d", GlobalConfig.ProxyHost, GlobalConfig.ProxyTracingPort)
	otlpHost := fmt.Sprintf("%s:%d", GlobalConfig.ProxyHost, GlobalConfig.ProxyTracingPort)
	log.Printf("NewGlobalTracer: 2: otlpHost:%s", otlpHost)

	ctx := context.Background()

	//	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	//	conn, err := grpc.DialContext(ctx, otlpHost, grpc.WithTransportCredentials(insecure.NewCredentials()))
	conn, err := grpc.DialContext(ctx, otlpHost, grpc.WithTransportCredentials(insecure.NewCredentials()), grpc.WithBlock())
	handleErr(err, "failed to create gRPC connection to collector")
	log.Printf("NewGlobalTracer: 3")

	// Set up a trace exporter
	traceExporter, err := otlptracegrpc.New(ctx, otlptracegrpc.WithGRPCConn(conn))
	handleErr(err, "failed to create trace exporter")

	log.Printf("NewGlobalTracer: 4")
	// Register the trace exporter with a TracerProvider, using a batch
	// span processor to aggregate spans before export.
	bsp := sdktrace.NewBatchSpanProcessor(traceExporter)
	tracerProvider := sdktrace.NewTracerProvider(
		sdktrace.WithSampler(sdktrace.AlwaysSample()),
		sdktrace.WithResource(tags),
		sdktrace.WithSpanProcessor(bsp),
	)
	log.Printf("NewGlobalTracer: 5")
	otel.SetTracerProvider(tracerProvider)
	log.Printf("NewGlobalTracer: 6")

	otel.SetTextMapPropagator(
		propagation.NewCompositeTextMapPropagator(
			propagation.TraceContext{},
			propagation.Baggage{}, // this is not strictly necessary, but it is good to set
		),
	)
	// set global propagator to tracecontext (the default is no-op).
	//otel.SetTextMapPropagator(propagation.TraceContext{})
	log.Printf("NewGlobalTracer: 7")

	Gtrace = otel.Tracer(name)
	log.Printf("NewGlobalTracer: 8")

	return ioutil.NopCloser(nil)
	//	return func() {
	//		// Shutdown will flush any remaining spans and shut down the exporter.
	//		handleErr(tracerProvider.Shutdown(ctx), "failed to shutdown TracerProvider")
	//	}

}

func NewServerSpan(req *http.Request, spanName string) trace.Span {
	log.Printf("NewServerSpan 1: span: %s", spanName)

	ctx := req.Context()

	// pretty print request header info (including parent span info)
	fmt.Printf("--> %s\n\n", formatRequest(req))

	ctx, span := Gtrace.Start(ctx, spanName, trace.WithSpanKind(trace.SpanKindServer))
	defer span.End()

	log.Printf("NewServerSpan 2")
	return span
}

func handleErr(err error, message string) {
	if err != nil {
		log.Fatalf("%s: %v", message, err)
	}
}
