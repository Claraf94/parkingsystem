// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VehicleEntryExit.proto

package grpc.generated.VehicleEntryExit;

public interface ClientRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:smartparking.ClientRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string numberPlate = 1;</code>
   */
  java.lang.String getNumberPlate();
  /**
   * <code>string numberPlate = 1;</code>
   */
  com.google.protobuf.ByteString
      getNumberPlateBytes();

  /**
   * <pre>
   *here we have two possible operations: entry and exit
   * </pre>
   *
   * <code>string operation = 2;</code>
   */
  java.lang.String getOperation();
  /**
   * <pre>
   *here we have two possible operations: entry and exit
   * </pre>
   *
   * <code>string operation = 2;</code>
   */
  com.google.protobuf.ByteString
      getOperationBytes();
}
