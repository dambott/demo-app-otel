package com.wfsample.notification;

import com.google.common.collect.ImmutableMap;
import com.wfsample.service.NotificationApi;
import org.apache.commons.lang3.exception.ExceptionUtils;

//import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.contrib.concurrent.TracedExecutorService;
//import io.opentracing.log.Fields;
//import io.opentracing.tag.Tags;
import io.opentracing.util.GlobalTracer;

import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation of Notification Service.
 *
 * @author Hao Song (songhao@vmware.com).
 */
@Service
public class NotificationService implements NotificationApi {
  private final Tracer tracer;
  private final AtomicInteger counter = new AtomicInteger(0);
  private final ExecutorService notificationExecutor;

  @Autowired
  public NotificationService() {
    this.tracer = GlobalTracer.get();
    notificationExecutor = new TracedExecutorService(
            Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors()), tracer);
  }

  public Response notify(String trackNum) {
    try {
      try {
        Thread.sleep(50);
        if (counter.incrementAndGet() % 500 == 0) {
          throw new ConnectTimeoutException();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (Exception e) {
      }
    } finally {
    }
    
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Response.accepted().build();
  }

  class InternalNotifyService implements Runnable {
    @Override
    public void run() {
      try {
        try {
          Thread.sleep(200);
          if (counter.incrementAndGet() % 100 == 0) {
            throw new NullPointerException();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (Exception e) {
        }
      } finally {
      }
    }
  }

}
