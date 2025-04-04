// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TicketPayment.proto

package grpc.generated.TicketPayment;

/**
 * <pre>
 *Request message for making payment
 * </pre>
 *
 * Protobuf type {@code smartparking.ClientRequest}
 */
public  final class ClientRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smartparking.ClientRequest)
    ClientRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ClientRequest.newBuilder() to construct.
  private ClientRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ClientRequest() {
    paymentType_ = "";
    amount_ = 0D;
    paymentID_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ClientRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            paymentType_ = s;
            break;
          }
          case 17: {

            amount_ = input.readDouble();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            paymentID_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.generated.TicketPayment.TicketPaymentImpl.internal_static_smartparking_ClientRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.generated.TicketPayment.TicketPaymentImpl.internal_static_smartparking_ClientRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.generated.TicketPayment.ClientRequest.class, grpc.generated.TicketPayment.ClientRequest.Builder.class);
  }

  public static final int PAYMENTTYPE_FIELD_NUMBER = 1;
  private volatile java.lang.Object paymentType_;
  /**
   * <pre>
   *Card, cash, voucher
   * </pre>
   *
   * <code>string paymentType = 1;</code>
   */
  public java.lang.String getPaymentType() {
    java.lang.Object ref = paymentType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      paymentType_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *Card, cash, voucher
   * </pre>
   *
   * <code>string paymentType = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPaymentTypeBytes() {
    java.lang.Object ref = paymentType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      paymentType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AMOUNT_FIELD_NUMBER = 2;
  private double amount_;
  /**
   * <code>double amount = 2;</code>
   */
  public double getAmount() {
    return amount_;
  }

  public static final int PAYMENTID_FIELD_NUMBER = 3;
  private volatile java.lang.Object paymentID_;
  /**
   * <code>string paymentID = 3;</code>
   */
  public java.lang.String getPaymentID() {
    java.lang.Object ref = paymentID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      paymentID_ = s;
      return s;
    }
  }
  /**
   * <code>string paymentID = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPaymentIDBytes() {
    java.lang.Object ref = paymentID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      paymentID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPaymentTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, paymentType_);
    }
    if (amount_ != 0D) {
      output.writeDouble(2, amount_);
    }
    if (!getPaymentIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, paymentID_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPaymentTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, paymentType_);
    }
    if (amount_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, amount_);
    }
    if (!getPaymentIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, paymentID_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.generated.TicketPayment.ClientRequest)) {
      return super.equals(obj);
    }
    grpc.generated.TicketPayment.ClientRequest other = (grpc.generated.TicketPayment.ClientRequest) obj;

    boolean result = true;
    result = result && getPaymentType()
        .equals(other.getPaymentType());
    result = result && (
        java.lang.Double.doubleToLongBits(getAmount())
        == java.lang.Double.doubleToLongBits(
            other.getAmount()));
    result = result && getPaymentID()
        .equals(other.getPaymentID());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PAYMENTTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getPaymentType().hashCode();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAmount()));
    hash = (37 * hash) + PAYMENTID_FIELD_NUMBER;
    hash = (53 * hash) + getPaymentID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.generated.TicketPayment.ClientRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.generated.TicketPayment.ClientRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *Request message for making payment
   * </pre>
   *
   * Protobuf type {@code smartparking.ClientRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smartparking.ClientRequest)
      grpc.generated.TicketPayment.ClientRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.generated.TicketPayment.TicketPaymentImpl.internal_static_smartparking_ClientRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.generated.TicketPayment.TicketPaymentImpl.internal_static_smartparking_ClientRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.generated.TicketPayment.ClientRequest.class, grpc.generated.TicketPayment.ClientRequest.Builder.class);
    }

    // Construct using grpc.generated.TicketPayment.ClientRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      paymentType_ = "";

      amount_ = 0D;

      paymentID_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.generated.TicketPayment.TicketPaymentImpl.internal_static_smartparking_ClientRequest_descriptor;
    }

    @java.lang.Override
    public grpc.generated.TicketPayment.ClientRequest getDefaultInstanceForType() {
      return grpc.generated.TicketPayment.ClientRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.generated.TicketPayment.ClientRequest build() {
      grpc.generated.TicketPayment.ClientRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.generated.TicketPayment.ClientRequest buildPartial() {
      grpc.generated.TicketPayment.ClientRequest result = new grpc.generated.TicketPayment.ClientRequest(this);
      result.paymentType_ = paymentType_;
      result.amount_ = amount_;
      result.paymentID_ = paymentID_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.generated.TicketPayment.ClientRequest) {
        return mergeFrom((grpc.generated.TicketPayment.ClientRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.generated.TicketPayment.ClientRequest other) {
      if (other == grpc.generated.TicketPayment.ClientRequest.getDefaultInstance()) return this;
      if (!other.getPaymentType().isEmpty()) {
        paymentType_ = other.paymentType_;
        onChanged();
      }
      if (other.getAmount() != 0D) {
        setAmount(other.getAmount());
      }
      if (!other.getPaymentID().isEmpty()) {
        paymentID_ = other.paymentID_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.generated.TicketPayment.ClientRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.generated.TicketPayment.ClientRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object paymentType_ = "";
    /**
     * <pre>
     *Card, cash, voucher
     * </pre>
     *
     * <code>string paymentType = 1;</code>
     */
    public java.lang.String getPaymentType() {
      java.lang.Object ref = paymentType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        paymentType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *Card, cash, voucher
     * </pre>
     *
     * <code>string paymentType = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPaymentTypeBytes() {
      java.lang.Object ref = paymentType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        paymentType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *Card, cash, voucher
     * </pre>
     *
     * <code>string paymentType = 1;</code>
     */
    public Builder setPaymentType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      paymentType_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Card, cash, voucher
     * </pre>
     *
     * <code>string paymentType = 1;</code>
     */
    public Builder clearPaymentType() {
      
      paymentType_ = getDefaultInstance().getPaymentType();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Card, cash, voucher
     * </pre>
     *
     * <code>string paymentType = 1;</code>
     */
    public Builder setPaymentTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      paymentType_ = value;
      onChanged();
      return this;
    }

    private double amount_ ;
    /**
     * <code>double amount = 2;</code>
     */
    public double getAmount() {
      return amount_;
    }
    /**
     * <code>double amount = 2;</code>
     */
    public Builder setAmount(double value) {
      
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double amount = 2;</code>
     */
    public Builder clearAmount() {
      
      amount_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object paymentID_ = "";
    /**
     * <code>string paymentID = 3;</code>
     */
    public java.lang.String getPaymentID() {
      java.lang.Object ref = paymentID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        paymentID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string paymentID = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPaymentIDBytes() {
      java.lang.Object ref = paymentID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        paymentID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string paymentID = 3;</code>
     */
    public Builder setPaymentID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      paymentID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string paymentID = 3;</code>
     */
    public Builder clearPaymentID() {
      
      paymentID_ = getDefaultInstance().getPaymentID();
      onChanged();
      return this;
    }
    /**
     * <code>string paymentID = 3;</code>
     */
    public Builder setPaymentIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      paymentID_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:smartparking.ClientRequest)
  }

  // @@protoc_insertion_point(class_scope:smartparking.ClientRequest)
  private static final grpc.generated.TicketPayment.ClientRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.generated.TicketPayment.ClientRequest();
  }

  public static grpc.generated.TicketPayment.ClientRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ClientRequest>
      PARSER = new com.google.protobuf.AbstractParser<ClientRequest>() {
    @java.lang.Override
    public ClientRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ClientRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ClientRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ClientRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.generated.TicketPayment.ClientRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

