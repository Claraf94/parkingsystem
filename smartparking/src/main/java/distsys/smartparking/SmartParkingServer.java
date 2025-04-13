/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import com.google.protobuf.Empty;
import grpc.generated.TrackingSpaces.TrackingSpacesImpl;
import grpc.generated.TrackingSpaces.TrackingSpacesServiceGrpc.TrackingSpacesServiceImplBase;
import grpc.generated.Reservation.ReservationReply;
import grpc.generated.Reservation.ReservationRequest;
import java.io.IOException;
import java.util.logging.Logger;
import grpc.generated.VehicleEntryExit.ClientRequest;
import grpc.generated.VehicleEntryExit.ClientReply;
import grpc.generated.VehicleEntryExit.VehicleEntryExitServiceGrpc.VehicleEntryExitServiceImplBase;
import grpc.generated.TrackingSpaces.SpotsAvailability;
import grpc.generated.TrackingSpaces.TrackingSpacesServiceGrpc.TrackingSpacesServiceImplBase;
import grpc.generated.Reservation.ReservationServiceGrpc.ReservationServiceImplBase;
import grpc.generated.TicketPayment.TicketPaymentReply;
import grpc.generated.TicketPayment.TicketPaymentRequest;
import grpc.generated.TicketPayment.TicketPaymentServiceGrpc.TicketPaymentServiceImplBase;
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
        TrackingSpacesServiceImpl trackingSpacesService = new TrackingSpacesServiceImpl();
        ReservationServiceImpl reservationService = new ReservationServiceImpl();
        TicketPaymentServiceImpl ticketPaymentService = new TicketPaymentServiceImpl();

        int port = 50051;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(vehicleEntryExitService)
                    .addService(trackingSpacesService)
                    .addService(reservationService)
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
    public static class VehicleEntryExitServiceImpl extends VehicleEntryExitServiceImplBase {

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

            if ("Entry".equalsIgnoreCase(operation)) {
                System.out.println("Vehicle entry number plate: " + request.getNumberPlate());
                confirmation = true;
            } else {
                System.out.println("Vehicle exit number plate: " + request.getNumberPlate());
                if (paidTicket) {
                    confirmation = true;
                    System.out.println("Ticket was paid.");
                } else {
                    confirmation = false;
                    System.out.println("Ticket wasn't paid.");
                }
            }

            ClientReply reply = ClientReply.newBuilder().setMessage("Vehicle number plate: " + request.getNumberPlate()
                    + ".\nOperation: " + request.getOperation()).setConfirmation(confirmation).build();

            responseObserver.onNext(reply);

            responseObserver.onCompleted();
        }
    }

    /*
    *
    *This service is a service streaming and returns information about available spots to park 
     */
    public static class TrackingSpacesServiceImpl extends TrackingSpacesServiceImplBase {

        //generating random number of spots available for parking
        Random random = new Random();
        int emptySpots = new Random().nextInt(101);

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
    }

    public static class ReservationServiceImpl extends ReservationServiceImplBase {

        Random random = new Random();
        int emptySpots = new Random().nextInt(101);
        List<String> reservations = new ArrayList<String>();

        public StreamObserver<ReservationRequest> reservation(StreamObserver<ReservationReply> responseObserver) {
            return new StreamObserver<ReservationRequest>() {
                boolean reserved = emptySpots > 0;
                String message;
                String reservationDetails = "";

                @Override
                public void onNext(ReservationRequest request) {
                    System.out.println("Reservation request received from the user: " + request.getUserID());
                    if (reserved) {
                        message = "Reservation successfully done for:";
                        reservationDetails = "User ID: " + request.getUserID() + "\n"
                                + "Date: " + request.getDate() + "\n"
                                + "Time: " + request.getTime() + "\n"
                                + "Reservation ID: " + request.getReservationID();

                        emptySpots--;
                        reservations.add(request.getUserID());
                    } else {
                        message = "No more available spots for reservation.";
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

    public static class TicketPaymentServiceImpl extends TicketPaymentServiceImplBase {
        @Override
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