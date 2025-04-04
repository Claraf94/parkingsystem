// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackingSpacesAndReservation.proto

package grpc.generated.TrackingSpacesAndReservation;

public interface ReservationReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:smartparking.ReservationReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *Message informing if the reservation was done succesfully or not
   * </pre>
   *
   * <code>string message = 1;</code>
   */
  java.lang.String getMessage();
  /**
   * <pre>
   *Message informing if the reservation was done succesfully or not
   * </pre>
   *
   * <code>string message = 1;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <pre>
   *True or false to inform about the reservation
   * </pre>
   *
   * <code>bool reserved = 2;</code>
   */
  boolean getReserved();

  /**
   * <code>string reservationDetails = 3;</code>
   */
  java.lang.String getReservationDetails();
  /**
   * <code>string reservationDetails = 3;</code>
   */
  com.google.protobuf.ByteString
      getReservationDetailsBytes();
}
