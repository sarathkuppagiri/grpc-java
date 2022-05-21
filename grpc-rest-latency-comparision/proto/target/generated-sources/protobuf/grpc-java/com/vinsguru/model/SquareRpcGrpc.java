package com.vinsguru.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: square.proto")
public final class SquareRpcGrpc {

  private SquareRpcGrpc() {}

  public static final String SERVICE_NAME = "vinsmath.SquareRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.vinsguru.model.Input,
      com.vinsguru.model.Output> getFindSquareUnaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findSquareUnary",
      requestType = com.vinsguru.model.Input.class,
      responseType = com.vinsguru.model.Output.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vinsguru.model.Input,
      com.vinsguru.model.Output> getFindSquareUnaryMethod() {
    io.grpc.MethodDescriptor<com.vinsguru.model.Input, com.vinsguru.model.Output> getFindSquareUnaryMethod;
    if ((getFindSquareUnaryMethod = SquareRpcGrpc.getFindSquareUnaryMethod) == null) {
      synchronized (SquareRpcGrpc.class) {
        if ((getFindSquareUnaryMethod = SquareRpcGrpc.getFindSquareUnaryMethod) == null) {
          SquareRpcGrpc.getFindSquareUnaryMethod = getFindSquareUnaryMethod = 
              io.grpc.MethodDescriptor.<com.vinsguru.model.Input, com.vinsguru.model.Output>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vinsmath.SquareRpc", "findSquareUnary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vinsguru.model.Input.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vinsguru.model.Output.getDefaultInstance()))
                  .setSchemaDescriptor(new SquareRpcMethodDescriptorSupplier("findSquareUnary"))
                  .build();
          }
        }
     }
     return getFindSquareUnaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.vinsguru.model.Input,
      com.vinsguru.model.Output> getFindSquareBiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findSquareBiStream",
      requestType = com.vinsguru.model.Input.class,
      responseType = com.vinsguru.model.Output.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.vinsguru.model.Input,
      com.vinsguru.model.Output> getFindSquareBiStreamMethod() {
    io.grpc.MethodDescriptor<com.vinsguru.model.Input, com.vinsguru.model.Output> getFindSquareBiStreamMethod;
    if ((getFindSquareBiStreamMethod = SquareRpcGrpc.getFindSquareBiStreamMethod) == null) {
      synchronized (SquareRpcGrpc.class) {
        if ((getFindSquareBiStreamMethod = SquareRpcGrpc.getFindSquareBiStreamMethod) == null) {
          SquareRpcGrpc.getFindSquareBiStreamMethod = getFindSquareBiStreamMethod = 
              io.grpc.MethodDescriptor.<com.vinsguru.model.Input, com.vinsguru.model.Output>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vinsmath.SquareRpc", "findSquareBiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vinsguru.model.Input.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vinsguru.model.Output.getDefaultInstance()))
                  .setSchemaDescriptor(new SquareRpcMethodDescriptorSupplier("findSquareBiStream"))
                  .build();
          }
        }
     }
     return getFindSquareBiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SquareRpcStub newStub(io.grpc.Channel channel) {
    return new SquareRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SquareRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SquareRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SquareRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SquareRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class SquareRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void findSquareUnary(com.vinsguru.model.Input request,
        io.grpc.stub.StreamObserver<com.vinsguru.model.Output> responseObserver) {
      asyncUnimplementedUnaryCall(getFindSquareUnaryMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vinsguru.model.Input> findSquareBiStream(
        io.grpc.stub.StreamObserver<com.vinsguru.model.Output> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindSquareBiStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindSquareUnaryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vinsguru.model.Input,
                com.vinsguru.model.Output>(
                  this, METHODID_FIND_SQUARE_UNARY)))
          .addMethod(
            getFindSquareBiStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.vinsguru.model.Input,
                com.vinsguru.model.Output>(
                  this, METHODID_FIND_SQUARE_BI_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class SquareRpcStub extends io.grpc.stub.AbstractStub<SquareRpcStub> {
    private SquareRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SquareRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SquareRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SquareRpcStub(channel, callOptions);
    }

    /**
     */
    public void findSquareUnary(com.vinsguru.model.Input request,
        io.grpc.stub.StreamObserver<com.vinsguru.model.Output> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindSquareUnaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vinsguru.model.Input> findSquareBiStream(
        io.grpc.stub.StreamObserver<com.vinsguru.model.Output> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindSquareBiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SquareRpcBlockingStub extends io.grpc.stub.AbstractStub<SquareRpcBlockingStub> {
    private SquareRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SquareRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SquareRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SquareRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.vinsguru.model.Output findSquareUnary(com.vinsguru.model.Input request) {
      return blockingUnaryCall(
          getChannel(), getFindSquareUnaryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SquareRpcFutureStub extends io.grpc.stub.AbstractStub<SquareRpcFutureStub> {
    private SquareRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SquareRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SquareRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SquareRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vinsguru.model.Output> findSquareUnary(
        com.vinsguru.model.Input request) {
      return futureUnaryCall(
          getChannel().newCall(getFindSquareUnaryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_SQUARE_UNARY = 0;
  private static final int METHODID_FIND_SQUARE_BI_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SquareRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SquareRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_SQUARE_UNARY:
          serviceImpl.findSquareUnary((com.vinsguru.model.Input) request,
              (io.grpc.stub.StreamObserver<com.vinsguru.model.Output>) responseObserver);
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
        case METHODID_FIND_SQUARE_BI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findSquareBiStream(
              (io.grpc.stub.StreamObserver<com.vinsguru.model.Output>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SquareRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SquareRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.vinsguru.model.Square.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SquareRpc");
    }
  }

  private static final class SquareRpcFileDescriptorSupplier
      extends SquareRpcBaseDescriptorSupplier {
    SquareRpcFileDescriptorSupplier() {}
  }

  private static final class SquareRpcMethodDescriptorSupplier
      extends SquareRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SquareRpcMethodDescriptorSupplier(String methodName) {
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
      synchronized (SquareRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SquareRpcFileDescriptorSupplier())
              .addMethod(getFindSquareUnaryMethod())
              .addMethod(getFindSquareBiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
