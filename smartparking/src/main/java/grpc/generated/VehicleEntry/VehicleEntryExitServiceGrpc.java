package grpc.generated.VehicleEntry;

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
 *this service will monitor vehicles entry and exit – Unary service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: VehicleEntryExit.proto")
public final class VehicleEntryExitServiceGrpc {

  private VehicleEntryExitServiceGrpc() {}

  public static final String SERVICE_NAME = "smartparking.VehicleEntryExitService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.VehicleEntry.ClientRequest,
      grpc.generated.VehicleEntry.ClientReply> getPerformingVehicleEntryExitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PerformingVehicleEntryExit",
      requestType = grpc.generated.VehicleEntry.ClientRequest.class,
      responseType = grpc.generated.VehicleEntry.ClientReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.VehicleEntry.ClientRequest,
      grpc.generated.VehicleEntry.ClientReply> getPerformingVehicleEntryExitMethod() {
    io.grpc.MethodDescriptor<grpc.generated.VehicleEntry.ClientRequest, grpc.generated.VehicleEntry.ClientReply> getPerformingVehicleEntryExitMethod;
    if ((getPerformingVehicleEntryExitMethod = VehicleEntryExitServiceGrpc.getPerformingVehicleEntryExitMethod) == null) {
      synchronized (VehicleEntryExitServiceGrpc.class) {
        if ((getPerformingVehicleEntryExitMethod = VehicleEntryExitServiceGrpc.getPerformingVehicleEntryExitMethod) == null) {
          VehicleEntryExitServiceGrpc.getPerformingVehicleEntryExitMethod = getPerformingVehicleEntryExitMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.VehicleEntry.ClientRequest, grpc.generated.VehicleEntry.ClientReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.VehicleEntryExitService", "PerformingVehicleEntryExit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.VehicleEntry.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.VehicleEntry.ClientReply.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleEntryExitServiceMethodDescriptorSupplier("PerformingVehicleEntryExit"))
                  .build();
          }
        }
     }
     return getPerformingVehicleEntryExitMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VehicleEntryExitServiceStub newStub(io.grpc.Channel channel) {
    return new VehicleEntryExitServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VehicleEntryExitServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VehicleEntryExitServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VehicleEntryExitServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VehicleEntryExitServiceFutureStub(channel);
  }

  /**
   * <pre>
   *this service will monitor vehicles entry and exit – Unary service
   * </pre>
   */
  public static abstract class VehicleEntryExitServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Processing entry and exit
     * </pre>
     */
    public void performingVehicleEntryExit(grpc.generated.VehicleEntry.ClientRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.VehicleEntry.ClientReply> responseObserver) {
      asyncUnimplementedUnaryCall(getPerformingVehicleEntryExitMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPerformingVehicleEntryExitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.VehicleEntry.ClientRequest,
                grpc.generated.VehicleEntry.ClientReply>(
                  this, METHODID_PERFORMING_VEHICLE_ENTRY_EXIT)))
          .build();
    }
  }

  /**
   * <pre>
   *this service will monitor vehicles entry and exit – Unary service
   * </pre>
   */
  public static final class VehicleEntryExitServiceStub extends io.grpc.stub.AbstractStub<VehicleEntryExitServiceStub> {
    private VehicleEntryExitServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleEntryExitServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleEntryExitServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleEntryExitServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Processing entry and exit
     * </pre>
     */
    public void performingVehicleEntryExit(grpc.generated.VehicleEntry.ClientRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.VehicleEntry.ClientReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPerformingVehicleEntryExitMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *this service will monitor vehicles entry and exit – Unary service
   * </pre>
   */
  public static final class VehicleEntryExitServiceBlockingStub extends io.grpc.stub.AbstractStub<VehicleEntryExitServiceBlockingStub> {
    private VehicleEntryExitServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleEntryExitServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleEntryExitServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleEntryExitServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Processing entry and exit
     * </pre>
     */
    public grpc.generated.VehicleEntry.ClientReply performingVehicleEntryExit(grpc.generated.VehicleEntry.ClientRequest request) {
      return blockingUnaryCall(
          getChannel(), getPerformingVehicleEntryExitMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *this service will monitor vehicles entry and exit – Unary service
   * </pre>
   */
  public static final class VehicleEntryExitServiceFutureStub extends io.grpc.stub.AbstractStub<VehicleEntryExitServiceFutureStub> {
    private VehicleEntryExitServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleEntryExitServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleEntryExitServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleEntryExitServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Processing entry and exit
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.VehicleEntry.ClientReply> performingVehicleEntryExit(
        grpc.generated.VehicleEntry.ClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPerformingVehicleEntryExitMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PERFORMING_VEHICLE_ENTRY_EXIT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VehicleEntryExitServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VehicleEntryExitServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PERFORMING_VEHICLE_ENTRY_EXIT:
          serviceImpl.performingVehicleEntryExit((grpc.generated.VehicleEntry.ClientRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.VehicleEntry.ClientReply>) responseObserver);
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

  private static abstract class VehicleEntryExitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VehicleEntryExitServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.VehicleEntry.VehicleEntryExitImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VehicleEntryExitService");
    }
  }

  private static final class VehicleEntryExitServiceFileDescriptorSupplier
      extends VehicleEntryExitServiceBaseDescriptorSupplier {
    VehicleEntryExitServiceFileDescriptorSupplier() {}
  }

  private static final class VehicleEntryExitServiceMethodDescriptorSupplier
      extends VehicleEntryExitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VehicleEntryExitServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VehicleEntryExitServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VehicleEntryExitServiceFileDescriptorSupplier())
              .addMethod(getPerformingVehicleEntryExitMethod())
              .build();
        }
      }
    }
    return result;
  }
}
