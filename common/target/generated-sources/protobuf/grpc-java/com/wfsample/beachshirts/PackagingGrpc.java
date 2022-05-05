package com.wfsample.beachshirts;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: beachshirts.proto")
public final class PackagingGrpc {

  private PackagingGrpc() {}

  public static final String SERVICE_NAME = "Packaging";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest,
      com.wfsample.beachshirts.PackedShirts> getWrapShirtsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "wrapShirts",
      requestType = com.wfsample.beachshirts.WrapRequest.class,
      responseType = com.wfsample.beachshirts.PackedShirts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest,
      com.wfsample.beachshirts.PackedShirts> getWrapShirtsMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest, com.wfsample.beachshirts.PackedShirts> getWrapShirtsMethod;
    if ((getWrapShirtsMethod = PackagingGrpc.getWrapShirtsMethod) == null) {
      synchronized (PackagingGrpc.class) {
        if ((getWrapShirtsMethod = PackagingGrpc.getWrapShirtsMethod) == null) {
          PackagingGrpc.getWrapShirtsMethod = getWrapShirtsMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.WrapRequest, com.wfsample.beachshirts.PackedShirts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "wrapShirts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.WrapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.PackedShirts.getDefaultInstance()))
              .setSchemaDescriptor(new PackagingMethodDescriptorSupplier("wrapShirts"))
              .build();
        }
      }
    }
    return getWrapShirtsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest,
      com.wfsample.beachshirts.GiftPack> getGiftWrapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giftWrap",
      requestType = com.wfsample.beachshirts.WrapRequest.class,
      responseType = com.wfsample.beachshirts.GiftPack.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest,
      com.wfsample.beachshirts.GiftPack> getGiftWrapMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrapRequest, com.wfsample.beachshirts.GiftPack> getGiftWrapMethod;
    if ((getGiftWrapMethod = PackagingGrpc.getGiftWrapMethod) == null) {
      synchronized (PackagingGrpc.class) {
        if ((getGiftWrapMethod = PackagingGrpc.getGiftWrapMethod) == null) {
          PackagingGrpc.getGiftWrapMethod = getGiftWrapMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.WrapRequest, com.wfsample.beachshirts.GiftPack>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giftWrap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.WrapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.GiftPack.getDefaultInstance()))
              .setSchemaDescriptor(new PackagingMethodDescriptorSupplier("giftWrap"))
              .build();
        }
      }
    }
    return getGiftWrapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrappingType,
      com.wfsample.beachshirts.Status> getRestockMaterialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "restockMaterial",
      requestType = com.wfsample.beachshirts.WrappingType.class,
      responseType = com.wfsample.beachshirts.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrappingType,
      com.wfsample.beachshirts.Status> getRestockMaterialMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.WrappingType, com.wfsample.beachshirts.Status> getRestockMaterialMethod;
    if ((getRestockMaterialMethod = PackagingGrpc.getRestockMaterialMethod) == null) {
      synchronized (PackagingGrpc.class) {
        if ((getRestockMaterialMethod = PackagingGrpc.getRestockMaterialMethod) == null) {
          PackagingGrpc.getRestockMaterialMethod = getRestockMaterialMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.WrappingType, com.wfsample.beachshirts.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "restockMaterial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.WrappingType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Status.getDefaultInstance()))
              .setSchemaDescriptor(new PackagingMethodDescriptorSupplier("restockMaterial"))
              .build();
        }
      }
    }
    return getRestockMaterialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void,
      com.wfsample.beachshirts.WrappingTypes> getGetPackingTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPackingTypes",
      requestType = com.wfsample.beachshirts.Void.class,
      responseType = com.wfsample.beachshirts.WrappingTypes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void,
      com.wfsample.beachshirts.WrappingTypes> getGetPackingTypesMethod() {
    io.grpc.MethodDescriptor<com.wfsample.beachshirts.Void, com.wfsample.beachshirts.WrappingTypes> getGetPackingTypesMethod;
    if ((getGetPackingTypesMethod = PackagingGrpc.getGetPackingTypesMethod) == null) {
      synchronized (PackagingGrpc.class) {
        if ((getGetPackingTypesMethod = PackagingGrpc.getGetPackingTypesMethod) == null) {
          PackagingGrpc.getGetPackingTypesMethod = getGetPackingTypesMethod =
              io.grpc.MethodDescriptor.<com.wfsample.beachshirts.Void, com.wfsample.beachshirts.WrappingTypes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPackingTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wfsample.beachshirts.WrappingTypes.getDefaultInstance()))
              .setSchemaDescriptor(new PackagingMethodDescriptorSupplier("getPackingTypes"))
              .build();
        }
      }
    }
    return getGetPackingTypesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PackagingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PackagingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PackagingStub>() {
        @java.lang.Override
        public PackagingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PackagingStub(channel, callOptions);
        }
      };
    return PackagingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PackagingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PackagingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PackagingBlockingStub>() {
        @java.lang.Override
        public PackagingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PackagingBlockingStub(channel, callOptions);
        }
      };
    return PackagingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PackagingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PackagingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PackagingFutureStub>() {
        @java.lang.Override
        public PackagingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PackagingFutureStub(channel, callOptions);
        }
      };
    return PackagingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PackagingImplBase implements io.grpc.BindableService {

    /**
     */
    public void wrapShirts(com.wfsample.beachshirts.WrapRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.PackedShirts> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWrapShirtsMethod(), responseObserver);
    }

    /**
     */
    public void giftWrap(com.wfsample.beachshirts.WrapRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.GiftPack> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiftWrapMethod(), responseObserver);
    }

    /**
     */
    public void restockMaterial(com.wfsample.beachshirts.WrappingType request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestockMaterialMethod(), responseObserver);
    }

    /**
     */
    public void getPackingTypes(com.wfsample.beachshirts.Void request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.WrappingTypes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPackingTypesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWrapShirtsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.WrapRequest,
                com.wfsample.beachshirts.PackedShirts>(
                  this, METHODID_WRAP_SHIRTS)))
          .addMethod(
            getGiftWrapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.WrapRequest,
                com.wfsample.beachshirts.GiftPack>(
                  this, METHODID_GIFT_WRAP)))
          .addMethod(
            getRestockMaterialMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.WrappingType,
                com.wfsample.beachshirts.Status>(
                  this, METHODID_RESTOCK_MATERIAL)))
          .addMethod(
            getGetPackingTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.wfsample.beachshirts.Void,
                com.wfsample.beachshirts.WrappingTypes>(
                  this, METHODID_GET_PACKING_TYPES)))
          .build();
    }
  }

  /**
   */
  public static final class PackagingStub extends io.grpc.stub.AbstractAsyncStub<PackagingStub> {
    private PackagingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PackagingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PackagingStub(channel, callOptions);
    }

    /**
     */
    public void wrapShirts(com.wfsample.beachshirts.WrapRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.PackedShirts> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWrapShirtsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void giftWrap(com.wfsample.beachshirts.WrapRequest request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.GiftPack> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiftWrapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restockMaterial(com.wfsample.beachshirts.WrappingType request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestockMaterialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPackingTypes(com.wfsample.beachshirts.Void request,
        io.grpc.stub.StreamObserver<com.wfsample.beachshirts.WrappingTypes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPackingTypesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PackagingBlockingStub extends io.grpc.stub.AbstractBlockingStub<PackagingBlockingStub> {
    private PackagingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PackagingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PackagingBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.wfsample.beachshirts.PackedShirts wrapShirts(com.wfsample.beachshirts.WrapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWrapShirtsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.GiftPack giftWrap(com.wfsample.beachshirts.WrapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiftWrapMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.Status restockMaterial(com.wfsample.beachshirts.WrappingType request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestockMaterialMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wfsample.beachshirts.WrappingTypes getPackingTypes(com.wfsample.beachshirts.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPackingTypesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PackagingFutureStub extends io.grpc.stub.AbstractFutureStub<PackagingFutureStub> {
    private PackagingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PackagingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PackagingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.PackedShirts> wrapShirts(
        com.wfsample.beachshirts.WrapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWrapShirtsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.GiftPack> giftWrap(
        com.wfsample.beachshirts.WrapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiftWrapMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.Status> restockMaterial(
        com.wfsample.beachshirts.WrappingType request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestockMaterialMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wfsample.beachshirts.WrappingTypes> getPackingTypes(
        com.wfsample.beachshirts.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPackingTypesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRAP_SHIRTS = 0;
  private static final int METHODID_GIFT_WRAP = 1;
  private static final int METHODID_RESTOCK_MATERIAL = 2;
  private static final int METHODID_GET_PACKING_TYPES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PackagingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PackagingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRAP_SHIRTS:
          serviceImpl.wrapShirts((com.wfsample.beachshirts.WrapRequest) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.PackedShirts>) responseObserver);
          break;
        case METHODID_GIFT_WRAP:
          serviceImpl.giftWrap((com.wfsample.beachshirts.WrapRequest) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.GiftPack>) responseObserver);
          break;
        case METHODID_RESTOCK_MATERIAL:
          serviceImpl.restockMaterial((com.wfsample.beachshirts.WrappingType) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.Status>) responseObserver);
          break;
        case METHODID_GET_PACKING_TYPES:
          serviceImpl.getPackingTypes((com.wfsample.beachshirts.Void) request,
              (io.grpc.stub.StreamObserver<com.wfsample.beachshirts.WrappingTypes>) responseObserver);
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

  private static abstract class PackagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PackagingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wfsample.beachshirts.BeachShirts.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Packaging");
    }
  }

  private static final class PackagingFileDescriptorSupplier
      extends PackagingBaseDescriptorSupplier {
    PackagingFileDescriptorSupplier() {}
  }

  private static final class PackagingMethodDescriptorSupplier
      extends PackagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PackagingMethodDescriptorSupplier(String methodName) {
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
      synchronized (PackagingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PackagingFileDescriptorSupplier())
              .addMethod(getWrapShirtsMethod())
              .addMethod(getGiftWrapMethod())
              .addMethod(getRestockMaterialMethod())
              .addMethod(getGetPackingTypesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
