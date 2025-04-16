/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import com.google.protobuf.Empty;
import grpc.generated.TrackingSpacesAndReservation.*;
import grpc.generated.VehicleEntryExit.*;
import grpc.generated.TicketPayment.*;
import java.io.IOException;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SmartParkingServer {

    private static final Logger logger = Logger.getLogger(SmartParkingServer.class.getName());

    public static void main(String[] args) {

        VehicleEntryExitServiceImpl vehicleEntryExitService = new VehicleEntryExitServiceImpl();
        TrackingSpacesAndReservationServiceImpl trackingSpacesAndReservationService = new TrackingSpacesAndReservationServiceImpl(); 
        TicketPaymentServiceImpl ticketPaymentService = new TicketPaymentServiceImpl();

        int port = 50051;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(vehicleEntryExitService)
                    .addService(trackingSpacesAndReservationService)
                    .addService(ticketPaymentService)
                    .build()
                    .start();
            logger.info("Server started, listening on " + port);
            System.out.println(" Server started, listening on " + port);
            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*
    *
    *This service is a unary service and returns information about entry/exit of vehicles
     */
    public static class VehicleEntryExitServiceImpl extends VehicleEntryExitServiceGrpc.VehicleEntryExitServiceImplBase{
        //unary 
        @Override
        public void performingVehicleEntryExit(ClientRequest request, StreamObserver<ClientReply> responseObserver) {

            System.out.println("Receiving vehicle entry/exit request");
            //checking if the vehicle is leaving or entrying the parking area
            String operation = request.getOperation();
            //in case the vehicle is leaving the parking area, we need to confirm if the ticket was paid
            //for the entrance will be always true
            boolean confirmation = false;
            //generating random confirmation(true or not) for the payment to confirm the exit
            boolean paidTicket = new Random().nextBoolean();
            String message = "";
            String carPlate = request.getNumberPlate().toUpperCase();
            
            //validating the car plate input
            //checking if the plate is not empty and follows the irish pattern
            if(!carPlate.isEmpty() && carPlate.matches("^\\d{2}-[A-Z]{1,3}-\\d{1,6}$")){
                if ("Entry".equalsIgnoreCase(operation)) {
                    confirmation = true;
                    message = "Vehicle entry number plate: " + carPlate;
                    System.out.println(message);
                } else {
                    message = "Vehicle exit number plate: " + carPlate + "\n";
                    if (paidTicket) {
                        confirmation = true;
                        message += "Ticket was paid.";
                        System.out.println("Ticket was paid.");
                    } else {
                        confirmation = false;
                        message += "Ticket was not paid.";
                        System.out.println("Ticket was not paid.");
                    }
                }
            }else{
                message = "Please, enter the vehicle registration number following the pattern: 01-D-12345.";
            }

            ClientReply reply = ClientReply.newBuilder().setMessage(message).setConfirmation(confirmation).build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    /*
    *
    *This service is a service streaming and returns information about available spots to park 
    *This service is also a bi-directional streaming and allows customer to make a booking for parking
    */
    public static class TrackingSpacesAndReservationServiceImpl
    extends TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceImplBase {
        //generating random number of spots available for parking
        Random random = new Random();
        int emptySpots = new Random().nextInt(101);
        List<String> reservations = new ArrayList<String>();
        
        //server streaming
        @Override
        public void trackingSpots(Empty request, StreamObserver<SpotsAvailability> responseObserver) {

            System.out.println("Checking available spots");

            do {
                SpotsAvailability reply = SpotsAvailability.newBuilder().setEmptySpots(emptySpots).build();

                responseObserver.onNext(reply);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //updating according to entry or exit of vehicles
                int operation = random.nextInt(2);
                int update = 0;

                switch (operation) {
                    //vehicle entry
                    case 0:
                        update = 1;
                        break;
                    //vehicle exit
                    case 1:
                        update = -1;
                        break;
                }

                emptySpots = emptySpots + update;

            } while (emptySpots > 0 && emptySpots <= 100);

            System.out.println("No more spots available for parking.");
            responseObserver.onCompleted();
        }
        
        //bi-directional streaming 
        @Override
        public StreamObserver<ReservationRequest> reservation(StreamObserver<ReservationReply> responseObserver) {
            return new StreamObserver<ReservationRequest>() {
                boolean reserved = emptySpots > 0;
                
                @Override
                public void onNext(ReservationRequest request) {
                    String userID = request.getUserID();
                    String date = request.getDate();
                    String time = request.getTime();
                    String reservationID = request.getReservationID();
                    String message;
                    String reservationDetails = "";

                    //making sure all the fields were inserted - date and time need to be checked using the spaces
                    //because of the formatted text field that were set for them
                    if (!userID.isEmpty() && !date.trim().equals("  /  /    ") && !time.trim().equals("  :  ")){
                        //making sure the fields date and time are compatible
                        if(time.matches("([01][0-9]|2[0-3]):([0-5][0-9])")&& date.matches("^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/202[5]$")){
                            System.out.println("Reservation request received from the user: " + userID);
                            if (reserved) {
                                message = "Reservation successfully done for:";
                                reservationDetails = "User ID: " + userID + "\n"
                                        + "Date: " + date + "\n"
                                        + "Time: " + time + "\n"
                                        + "Reservation ID: " + reservationID;
                                emptySpots--;
                                reservations.add(userID);
                            } else {
                                message = "No more available spots for reservation.";
                            }
                        }else{
                            message = "Please check if the time is in the format HH:mm and the date is in the format dd/MM/2025.";
                        }
                    }else{
                        message = "Please fill in all the fields.";
                    }        

                    ReservationReply reply = ReservationReply.newBuilder()
                            .setReserved(reserved)
                            .setMessage(message)
                            .setReservationDetails(reservationDetails)
                            .build();

                    responseObserver.onNext(reply);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Erro while trying to make the reservation: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed.");
                    responseObserver.onCompleted();
                }
            };
        }
    }
    
    //client streaming
    public static class TicketPaymentServiceImpl extends TicketPaymentServiceGrpc.TicketPaymentServiceImplBase {
        public StreamObserver<TicketPaymentRequest> processPayment(StreamObserver<TicketPaymentReply> responseObserver) {
            return new StreamObserver<TicketPaymentRequest>() {
                double total = 0;

                @Override
                public void onNext(TicketPaymentRequest request) {
                    System.out.println("Received payment:");
                    System.out.println("Type: " + request.getPaymentType());
                    System.out.println("Amount: €" + request.getAmount());
                    System.out.println("ID: " + request.getPaymentID());

                    total += request.getAmount();
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Error receiving payment: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    String receipt = UUID.randomUUID().toString();

                    TicketPaymentReply reply = TicketPaymentReply.newBuilder()
                            .setConfirmation(true)
                            .setReceiptID(receipt)
                            .build();

                    System.out.println("Payment complete. Total: €" + total + ", Receipt: " + receipt);

                    responseObserver.onNext(reply);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}