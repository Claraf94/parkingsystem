// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TicketPayment.proto

package grpc.generated.TicketPayment;

public final class TicketPaymentImpl {
  private TicketPaymentImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartparking_ClientRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartparking_ClientRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartparking_ClientReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartparking_ClientReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023TicketPayment.proto\022\014smartparking\"G\n\rC" +
      "lientRequest\022\023\n\013paymentType\030\001 \001(\t\022\016\n\006amo" +
      "unt\030\002 \001(\001\022\021\n\tpaymentID\030\003 \001(\t\"6\n\013ClientRe" +
      "ply\022\024\n\014confirmation\030\002 \001(\010\022\021\n\treceiptID\030\003" +
      " \001(\t2d\n\024TicketPaymentService\022L\n\016ProcessP" +
      "ayment\022\033.smartparking.ClientRequest\032\031.sm" +
      "artparking.ClientReply\"\000(\001B3\n\034grpc.gener" +
      "ated.TicketPaymentB\021TicketPaymentImplP\001b" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_smartparking_ClientRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smartparking_ClientRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartparking_ClientRequest_descriptor,
        new java.lang.String[] { "PaymentType", "Amount", "PaymentID", });
    internal_static_smartparking_ClientReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smartparking_ClientReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartparking_ClientReply_descriptor,
        new java.lang.String[] { "Confirmation", "ReceiptID", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
