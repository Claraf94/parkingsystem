package grpc.generated.TrackingSpacesAndReservation;

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
 *This service will monitor the available spots for parking as well as allow customer to make a reservation
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TrackingSpacesAndReservation.proto")
public final class TrackingSpacesAndReservationServiceGrpc {

  private TrackingSpacesAndReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "smartparking.TrackingSpacesAndReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> getTrackingSpotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackingSpots",
      requestType = com.google.protobuf.Empty.class,
      responseType = grpc.generated.TrackingSpacesAndReservation.SpotsAvailability.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> getTrackingSpotsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> getTrackingSpotsMethod;
    if ((getTrackingSpotsMethod = TrackingSpacesAndReservationServiceGrpc.getTrackingSpotsMethod) == null) {
      synchronized (TrackingSpacesAndReservationServiceGrpc.class) {
        if ((getTrackingSpotsMethod = TrackingSpacesAndReservationServiceGrpc.getTrackingSpotsMethod) == null) {
          TrackingSpacesAndReservationServiceGrpc.getTrackingSpotsMethod = getTrackingSpotsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, grpc.generated.TrackingSpacesAndReservation.SpotsAvailability>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.TrackingSpacesAndReservationService", "TrackingSpots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TrackingSpacesAndReservation.SpotsAvailability.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackingSpacesAndReservationServiceMethodDescriptorSupplier("TrackingSpots"))
                  .build();
          }
        }
     }
     return getTrackingSpotsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.TrackingSpacesAndReservation.ReservationRequest,
      grpc.generated.TrackingSpacesAndReservation.ReservationReply> getReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Reservation",
      requestType = grpc.generated.TrackingSpacesAndReservation.ReservationRequest.class,
      responseType = grpc.generated.TrackingSpacesAndReservation.ReservationReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.generated.TrackingSpacesAndReservation.ReservationRequest,
      grpc.generated.TrackingSpacesAndReservation.ReservationReply> getReservationMethod() {
    io.grpc.MethodDescriptor<grpc.generated.TrackingSpacesAndReservation.ReservationRequest, grpc.generated.TrackingSpacesAndReservation.ReservationReply> getReservationMethod;
    if ((getReservationMethod = TrackingSpacesAndReservationServiceGrpc.getReservationMethod) == null) {
      synchronized (TrackingSpacesAndReservationServiceGrpc.class) {
        if ((getReservationMethod = TrackingSpacesAndReservationServiceGrpc.getReservationMethod) == null) {
          TrackingSpacesAndReservationServiceGrpc.getReservationMethod = getReservationMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.TrackingSpacesAndReservation.ReservationRequest, grpc.generated.TrackingSpacesAndReservation.ReservationReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.TrackingSpacesAndReservationService", "Reservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TrackingSpacesAndReservation.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TrackingSpacesAndReservation.ReservationReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackingSpacesAndReservationServiceMethodDescriptorSupplier("Reservation"))
                  .build();
          }
        }
     }
     return getReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrackingSpacesAndReservationServiceStub newStub(io.grpc.Channel channel) {
    return new TrackingSpacesAndReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackingSpacesAndReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrackingSpacesAndReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrackingSpacesAndReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrackingSpacesAndReservationServiceFutureStub(channel);
  }

  /**
   * <pre>
   *This service will monitor the available spots for parking as well as allow customer to make a reservation
   * </pre>
   */
  public static abstract class TrackingSpacesAndReservationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Provides continuous information about available spots - Server Streaming
     * </pre>
     */
    public void trackingSpots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> responseObserver) {
      asyncUnimplementedUnaryCall(getTrackingSpotsMethod(), responseObserver);
    }

    /**
     * <pre>
     *Provides data about reservation - bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.ReservationRequest> reservation(
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.ReservationReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrackingSpotsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                grpc.generated.TrackingSpacesAndReservation.SpotsAvailability>(
                  this, METHODID_TRACKING_SPOTS)))
          .addMethod(
            getReservationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.generated.TrackingSpacesAndReservation.ReservationRequest,
                grpc.generated.TrackingSpacesAndReservation.ReservationReply>(
                  this, METHODID_RESERVATION)))
          .build();
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parking as well as allow customer to make a reservation
   * </pre>
   */
  public static final class TrackingSpacesAndReservationServiceStub extends io.grpc.stub.AbstractStub<TrackingSpacesAndReservationServiceStub> {
    private TrackingSpacesAndReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesAndReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesAndReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesAndReservationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Provides continuous information about available spots - Server Streaming
     * </pre>
     */
    public void trackingSpots(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTrackingSpotsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Provides data about reservation - bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.ReservationRequest> reservation(
        io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.ReservationReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getReservationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parking as well as allow customer to make a reservation
   * </pre>
   */
  public static final class TrackingSpacesAndReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<TrackingSpacesAndReservationServiceBlockingStub> {
    private TrackingSpacesAndReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesAndReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesAndReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesAndReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Provides continuous information about available spots - Server Streaming
     * </pre>
     */
    public java.util.Iterator<grpc.generated.TrackingSpacesAndReservation.SpotsAvailability> trackingSpots(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getTrackingSpotsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *This service will monitor the available spots for parking as well as allow customer to make a reservation
   * </pre>
   */
  public static final class TrackingSpacesAndReservationServiceFutureStub extends io.grpc.stub.AbstractStub<TrackingSpacesAndReservationServiceFutureStub> {
    private TrackingSpacesAndReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackingSpacesAndReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingSpacesAndReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackingSpacesAndReservationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TRACKING_SPOTS = 0;
  private static final int METHODID_RESERVATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrackingSpacesAndReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrackingSpacesAndReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRACKING_SPOTS:
          serviceImpl.trackingSpots((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.SpotsAvailability>) responseObserver);
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
        case METHODID_RESERVATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reservation(
              (io.grpc.stub.StreamObserver<grpc.generated.TrackingSpacesAndReservation.ReservationReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrackingSpacesAndReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackingSpacesAndReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.TrackingSpacesAndReservation.TrackingSpacesAndReservationImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrackingSpacesAndReservationService");
    }
  }

  private static final class TrackingSpacesAndReservationServiceFileDescriptorSupplier
      extends TrackingSpacesAndReservationServiceBaseDescriptorSupplier {
    TrackingSpacesAndReservationServiceFileDescriptorSupplier() {}
  }

  private static final class TrackingSpacesAndReservationServiceMethodDescriptorSupplier
      extends TrackingSpacesAndReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrackingSpacesAndReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrackingSpacesAndReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrackingSpacesAndReservationServiceFileDescriptorSupplier())
              .addMethod(getTrackingSpotsMethod())
              .addMethod(getReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
