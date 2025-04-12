package grpc.generated.TrackingSpaces;

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
 * <pre>
 *This service will monitor the available spots for parkin
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TrackingSpaces.proto")
public final class TrackingSpacesServiceGrpc {

  private TrackingSpacesServiceGrpc() {}

  public static final String SERVICE_NAME = "smartparking.TrackingSpacesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.generated.TrackingSpaces.SpotsAvailability> getTrackingSpotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackingSpots",
      requestType = com.google.protobuf.Empty.class,
      responseType = grpc.generated.TrackingSpaces.SpotsAvailability.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.generated.TrackingSpaces.SpotsAvailability> getTrackingSpotsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, grpc.generated.TrackingSpaces.SpotsAvailability> getTrackingSpotsMethod;
    if ((getTrackingSpotsMethod = TrackingSpacesServiceGrpc.getTrackingSpotsMethod) == null) {
      synchronized (TrackingSpacesServiceGrpc.class) {
        if ((getTrackingSpotsMethod = TrackingSpacesServiceGrpc.getTrackingSpotsMethod) == null) {
          TrackingSpacesServiceGrpc.getTrackingSpotsMethod = getTrackingSpotsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, grpc.generated.TrackingSpaces.SpotsAvailability>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.TrackingSpacesService", "TrackingSpots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TrackingSpaces.SpotsAvailability.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackingSpacesServiceMethodDescriptorSupplier("TrackingSpots"))
                  .build();
          }
        }
     }
     return getTrackingSpotsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrackingSpacesServiceStub newStub(io.grpc.Channel channel) {
    return new TrackingSpacesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackingSpacesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrackingSpacesServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrackingSpacesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrackingSpacesServiceFutureStub(channel);
  }

  /**
   * <pre>
   *This service will monitor the available spots for parkin
   * </pre>
   */
  public static abstract class TrackingSpacesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Provides continuos information about available spots - Server Streaming
     * </pre>
     */
    public void trackingSpots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpaces.SpotsAvailability> responseObserver) {
      asyncUnimplementedUnaryCall(getTrackingSpotsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrackingSpotsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                grpc.generated.TrackingSpaces.SpotsAvailability>(
                  this, METHODID_TRACKING_SPOTS)))
          .build();
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parkin
   * </pre>
   */
  public static final class TrackingSpacesServiceStub extends io.grpc.stub.AbstractStub<TrackingSpacesServiceStub> {
    private TrackingSpacesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Provides continuos information about available spots - Server Streaming
     * </pre>
     */
    public void trackingSpots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpaces.SpotsAvailability> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTrackingSpotsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parkin
   * </pre>
   */
  public static final class TrackingSpacesServiceBlockingStub extends io.grpc.stub.AbstractStub<TrackingSpacesServiceBlockingStub> {
    private TrackingSpacesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Provides continuos information about available spots - Server Streaming
     * </pre>
     */
    public java.util.Iterator<grpc.generated.TrackingSpaces.SpotsAvailability> trackingSpots(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getTrackingSpotsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parkin
   * </pre>
   */
  public static final class TrackingSpacesServiceFutureStub extends io.grpc.stub.AbstractStub<TrackingSpacesServiceFutureStub> {
    private TrackingSpacesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TRACKING_SPOTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrackingSpacesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrackingSpacesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRACKING_SPOTS:
          serviceImpl.trackingSpots((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.generated.TrackingSpaces.SpotsAvailability>) responseObserver);
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

  private static abstract class TrackingSpacesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackingSpacesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.TrackingSpaces.TrackingSpacesImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrackingSpacesService");
    }
  }

  private static final class TrackingSpacesServiceFileDescriptorSupplier
      extends TrackingSpacesServiceBaseDescriptorSupplier {
    TrackingSpacesServiceFileDescriptorSupplier() {}
  }

  private static final class TrackingSpacesServiceMethodDescriptorSupplier
      extends TrackingSpacesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrackingSpacesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrackingSpacesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrackingSpacesServiceFileDescriptorSupplier())
              .addMethod(getTrackingSpotsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
