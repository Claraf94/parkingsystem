package grpc.generated.TicketPayment;

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
 *This service will process the ticket payment 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TicketPayment.proto")
public final class TicketPaymentServiceGrpc {

  private TicketPaymentServiceGrpc() {}

  public static final String SERVICE_NAME = "smartparking.TicketPaymentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.TicketPayment.AmountRequest,
      grpc.generated.TicketPayment.AmountReply> getRandomAmountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "randomAmount",
      requestType = grpc.generated.TicketPayment.AmountRequest.class,
      responseType = grpc.generated.TicketPayment.AmountReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.TicketPayment.AmountRequest,
      grpc.generated.TicketPayment.AmountReply> getRandomAmountMethod() {
    io.grpc.MethodDescriptor<grpc.generated.TicketPayment.AmountRequest, grpc.generated.TicketPayment.AmountReply> getRandomAmountMethod;
    if ((getRandomAmountMethod = TicketPaymentServiceGrpc.getRandomAmountMethod) == null) {
      synchronized (TicketPaymentServiceGrpc.class) {
        if ((getRandomAmountMethod = TicketPaymentServiceGrpc.getRandomAmountMethod) == null) {
          TicketPaymentServiceGrpc.getRandomAmountMethod = getRandomAmountMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.TicketPayment.AmountRequest, grpc.generated.TicketPayment.AmountReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.TicketPaymentService", "randomAmount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TicketPayment.AmountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TicketPayment.AmountReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketPaymentServiceMethodDescriptorSupplier("randomAmount"))
                  .build();
          }
        }
     }
     return getRandomAmountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.TicketPayment.TicketPaymentRequest,
      grpc.generated.TicketPayment.TicketPaymentReply> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPayment",
      requestType = grpc.generated.TicketPayment.TicketPaymentRequest.class,
      responseType = grpc.generated.TicketPayment.TicketPaymentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.generated.TicketPayment.TicketPaymentRequest,
      grpc.generated.TicketPayment.TicketPaymentReply> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<grpc.generated.TicketPayment.TicketPaymentRequest, grpc.generated.TicketPayment.TicketPaymentReply> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = TicketPaymentServiceGrpc.getProcessPaymentMethod) == null) {
      synchronized (TicketPaymentServiceGrpc.class) {
        if ((getProcessPaymentMethod = TicketPaymentServiceGrpc.getProcessPaymentMethod) == null) {
          TicketPaymentServiceGrpc.getProcessPaymentMethod = getProcessPaymentMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.TicketPayment.TicketPaymentRequest, grpc.generated.TicketPayment.TicketPaymentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartparking.TicketPaymentService", "ProcessPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TicketPayment.TicketPaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.TicketPayment.TicketPaymentReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketPaymentServiceMethodDescriptorSupplier("ProcessPayment"))
                  .build();
          }
        }
     }
     return getProcessPaymentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TicketPaymentServiceStub newStub(io.grpc.Channel channel) {
    return new TicketPaymentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TicketPaymentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TicketPaymentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TicketPaymentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TicketPaymentServiceFutureStub(channel);
  }

  /**
   * <pre>
   *This service will process the ticket payment 
   * </pre>
   */
  public static abstract class TicketPaymentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary - just to simulate and generate a random value to be paid
     * </pre>
     */
    public void randomAmount(grpc.generated.TicketPayment.AmountRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.AmountReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRandomAmountMethod(), responseObserver);
    }

    /**
     * <pre>
     *Client streaming - can process multiple payments to achieve the total
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.TicketPaymentRequest> processPayment(
        io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.TicketPaymentReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getProcessPaymentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRandomAmountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.TicketPayment.AmountRequest,
                grpc.generated.TicketPayment.AmountReply>(
                  this, METHODID_RANDOM_AMOUNT)))
          .addMethod(
            getProcessPaymentMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.generated.TicketPayment.TicketPaymentRequest,
                grpc.generated.TicketPayment.TicketPaymentReply>(
                  this, METHODID_PROCESS_PAYMENT)))
          .build();
    }
  }

  /**
   * <pre>
   *This service will process the ticket payment 
   * </pre>
   */
  public static final class TicketPaymentServiceStub extends io.grpc.stub.AbstractStub<TicketPaymentServiceStub> {
    private TicketPaymentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketPaymentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketPaymentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketPaymentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary - just to simulate and generate a random value to be paid
     * </pre>
     */
    public void randomAmount(grpc.generated.TicketPayment.AmountRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.AmountReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRandomAmountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Client streaming - can process multiple payments to achieve the total
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.TicketPaymentRequest> processPayment(
        io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.TicketPaymentReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *This service will process the ticket payment 
   * </pre>
   */
  public static final class TicketPaymentServiceBlockingStub extends io.grpc.stub.AbstractStub<TicketPaymentServiceBlockingStub> {
    private TicketPaymentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketPaymentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketPaymentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketPaymentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary - just to simulate and generate a random value to be paid
     * </pre>
     */
    public grpc.generated.TicketPayment.AmountReply randomAmount(grpc.generated.TicketPayment.AmountRequest request) {
      return blockingUnaryCall(
          getChannel(), getRandomAmountMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *This service will process the ticket payment 
   * </pre>
   */
  public static final class TicketPaymentServiceFutureStub extends io.grpc.stub.AbstractStub<TicketPaymentServiceFutureStub> {
    private TicketPaymentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketPaymentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketPaymentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketPaymentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary - just to simulate and generate a random value to be paid
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.TicketPayment.AmountReply> randomAmount(
        grpc.generated.TicketPayment.AmountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRandomAmountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RANDOM_AMOUNT = 0;
  private static final int METHODID_PROCESS_PAYMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TicketPaymentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TicketPaymentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RANDOM_AMOUNT:
          serviceImpl.randomAmount((grpc.generated.TicketPayment.AmountRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.AmountReply>) responseObserver);
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
        case METHODID_PROCESS_PAYMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processPayment(
              (io.grpc.stub.StreamObserver<grpc.generated.TicketPayment.TicketPaymentReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TicketPaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketPaymentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.TicketPayment.TicketPaymentImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TicketPaymentService");
    }
  }

  private static final class TicketPaymentServiceFileDescriptorSupplier
      extends TicketPaymentServiceBaseDescriptorSupplier {
    TicketPaymentServiceFileDescriptorSupplier() {}
  }

  private static final class TicketPaymentServiceMethodDescriptorSupplier
      extends TicketPaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TicketPaymentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TicketPaymentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TicketPaymentServiceFileDescriptorSupplier())
              .addMethod(getRandomAmountMethod())
              .addMethod(getProcessPaymentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
