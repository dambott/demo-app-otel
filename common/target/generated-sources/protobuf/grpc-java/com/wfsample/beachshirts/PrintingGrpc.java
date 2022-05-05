package com.wfsample.beachshirts;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: beachshirts.proto")
public final class PrintingGrpc {

  private PrintingGrpc() {}

  public static final String SERVICE_NAME = "Printing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.PrintRequest,
      com.wfsample.beachshirts.Shirt> getPrintShirtsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printShirts",
      requestType = com.wfsample.beachshirts.PrintRequest.class,
      responseType = com.wfsample.beachshirts.Shirt.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.PrintRequest,
      com.wfsample.beachshirts.Shirt> getPrintShirtsMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.PrintRequest, com.wfsample.beachshirts.Shirt> getPrintShirtsMethod;
    if ((getPrintShirtsMethod = PrintingGrpc.getPrintShirtsMethod) == null) {
      synchronized (PrintingGrpc.class) {
        if ((getPrintShirtsMethod = PrintingGrpc.getPrintShirtsMethod) == null) {
          PrintingGrpc.getPrintShirtsMethod = getPrintShirtsMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.PrintRequest, com.wfsample.beachshirts.Shirt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "printShirts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.PrintRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Shirt.getDefaultInstance()))
              .setSchemaDescriptor(new PrintingMethodDescriptorSupplier("printShirts"))
              .build();
        }
      }
    }
    return getPrintShirtsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color,
      com.wfsample.beachshirts.Status> getAddPrintColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addPrintColor",
      requestType = com.wfsample.beachshirts.Color.class,
      responseType = com.wfsample.beachshirts.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color,
      com.wfsample.beachshirts.Status> getAddPrintColorMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color, com.wfsample.beachshirts.Status> getAddPrintColorMethod;
    if ((getAddPrintColorMethod = PrintingGrpc.getAddPrintColorMethod) == null) {
      synchronized (PrintingGrpc.class) {
        if ((getAddPrintColorMethod = PrintingGrpc.getAddPrintColorMethod) == null) {
          PrintingGrpc.getAddPrintColorMethod = getAddPrintColorMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.Color, com.wfsample.beachshirts.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addPrintColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Color.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Status.getDefaultInstance()))
              .setSchemaDescriptor(new PrintingMethodDescriptorSupplier("addPrintColor"))
              .build();
        }
      }
    }
    return getAddPrintColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color,
      com.wfsample.beachshirts.Status> getRestockColorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "restockColor",
      requestType = com.wfsample.beachshirts.Color.class,
      responseType = com.wfsample.beachshirts.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color,
      com.wfsample.beachshirts.Status> getRestockColorMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.Color, com.wfsample.beachshirts.Status> getRestockColorMethod;
    if ((getRestockColorMethod = PrintingGrpc.getRestockColorMethod) == null) {
      synchronized (PrintingGrpc.class) {
        if ((getRestockColorMethod = PrintingGrpc.getRestockColorMethod) == null) {
          PrintingGrpc.getRestockColorMethod = getRestockColorMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.Color, com.wfsample.beachshirts.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "restockColor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Color.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Status.getDefaultInstance()))
              .setSchemaDescriptor(new PrintingMethodDescriptorSupplier("restockColor"))
              .build();
        }
      }
    }
    return getRestockColorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void,
      com.wfsample.beachshirts.AvailableColors> getGetAvailableColorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAvailableColors",
      requestType = com.wfsample.beachshirts.Void.class,
      responseType = com.wfsample.beachshirts.AvailableColors.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void,
      com.wfsample.beachshirts.AvailableColors> getGetAvailableColorsMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void, com.wfsample.beachshirts.AvailableColors> getGetAvailableColorsMethod;
    if ((getGetAvailableColorsMethod = PrintingGrpc.getGetAvailableColorsMethod) == null) {
      synchronized (PrintingGrpc.class) {
        if ((getGetAvailableColorsMethod = PrintingGrpc.getGetAvailableColorsMethod) == null) {
          PrintingGrpc.getGetAvailableColorsMethod = getGetAvailableColorsMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.Void, com.wfsample.beachshirts.AvailableColors>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAvailableColors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.AvailableColors.getDefaultInstance()))
              .setSchemaDescriptor(new PrintingMethodDescriptorSupplier("getAvailableColors"))
              .build();
        }
      }
    }
    return getGetAvailableColorsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrintingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintingStub>() {
        @java.lang.Override
        public PrintingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintingStub(channel, callOptions);
        }
      };
    return PrintingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrintingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintingBlockingStub>() {
        @java.lang.Override
        public PrintingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintingBlockingStub(channel, callOptions);
        }
      };
    return PrintingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrintingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintingFutureStub>() {
        @java.lang.Override
        public PrintingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintingFutureStub(channel, callOptions);
        }
      };
    return PrintingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrintingImplBase implements io.grpc.BindableService {

    /**
     */
    public void printShirts(com.wfsample.beachshirts.PrintRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Shirt> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintShirtsMethod(), responseObserver);
    }

    /**
     */
    public void addPrintColor(com.wfsample.beachshirts.Color request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddPrintColorMethod(), responseObserver);
    }

    /**
     */
    public void restockColor(com.wfsample.beachshirts.Color request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestockColorMethod(), responseObserver);
    }

    /**
     */
    public void getAvailableColors(com.wfsample.beachshirts.Void request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.AvailableColors> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAvailableColorsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrintShirtsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.wfsample.beachshirts.PrintRequest,
                com.wfsample.beachshirts.Shirt>(
                  this, METHODID_PRINT_SHIRTS)))
          .addMethod(
            getAddPrintColorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.Color,
                com.wfsample.beachshirts.Status>(
                  this, METHODID_ADD_PRINT_COLOR)))
          .addMethod(
            getRestockColorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.Color,
                com.wfsample.beachshirts.Status>(
                  this, METHODID_RESTOCK_COLOR)))
          .addMethod(
            getGetAvailableColorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.Void,
                com.wfsample.beachshirts.AvailableColors>(
                  this, METHODID_GET_AVAILABLE_COLORS)))
          .build();
    }
  }

  /**
   */
  public static final class PrintingStub extends io.grpc.stub.AbstractAsyncStub<PrintingStub> {
    private PrintingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintingStub(channel, callOptions);
    }

    /**
     */
    public void printShirts(com.wfsample.beachshirts.PrintRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Shirt> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getPrintShirtsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPrintColor(com.wfsample.beachshirts.Color request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddPrintColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restockColor(com.wfsample.beachshirts.Color request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestockColorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailableColors(com.wfsample.beachshirts.Void request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.AvailableColors> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAvailableColorsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrintingBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrintingBlockingStub> {
    private PrintingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintingBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.wfsample.beachshirts.Shirt> printShirts(
        com.wfsample.beachshirts.PrintRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getPrintShirtsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.Status addPrintColor(com.wfsample.beachshirts.Color request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddPrintColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.Status restockColor(com.wfsample.beachshirts.Color request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestockColorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.AvailableColors getAvailableColors(com.wfsample.beachshirts.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAvailableColorsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrintingFutureStub extends io.grpc.stub.AbstractFutureStub<PrintingFutureStub> {
    private PrintingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.Status> addPrintColor(
        com.wfsample.beachshirts.Color request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddPrintColorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.Status> restockColor(
        com.wfsample.beachshirts.Color request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestockColorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.AvailableColors> getAvailableColors(
        com.wfsample.beachshirts.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAvailableColorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT_SHIRTS = 0;
  private static final int METHODID_ADD_PRINT_COLOR = 1;
  private static final int METHODID_RESTOCK_COLOR = 2;
  private static final int METHODID_GET_AVAILABLE_COLORS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrintingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrintingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRINT_SHIRTS:
          serviceImpl.printShirts((com.wfsample.beachshirts.PrintRequest) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Shirt>) responseObserver);
          break;
        case METHODID_ADD_PRINT_COLOR:
          serviceImpl.addPrintColor((com.wfsample.beachshirts.Color) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status>) responseObserver);
          break;
        case METHODID_RESTOCK_COLOR:
          serviceImpl.restockColor((com.wfsample.beachshirts.Color) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status>) responseObserver);
          break;
        case METHODID_GET_AVAILABLE_COLORS:
          serviceImpl.getAvailableColors((com.wfsample.beachshirts.Void) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.AvailableColors>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrintingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrintingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wfsample.beachshirts.BeachShirts.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Printing");
    }
  }

  private static final class PrintingFileDescriptorSupplier
      extends PrintingBaseDescriptorSupplier {
    PrintingFileDescriptorSupplier() {}
  }

  private static final class PrintingMethodDescriptorSupplier
      extends PrintingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrintingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrintingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrintingFileDescriptorSupplier())
              .addMethod(getPrintShirtsMethod())
              .addMethod(getAddPrintColorMethod())
              .addMethod(getRestockColorMethod())
              .addMethod(getGetAvailableColorsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
