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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class SmartParkingServer {

    private static final Logger logger = Logger.getLogger(SmartParkingServer.class.getName());

    public static void main(String[] args) {

        VehicleEntryExitServiceImpl vehicleEntryExitService = new VehicleEntryExitServiceImpl();
        TrackingSpacesAndReservationServiceImpl trackingSpacesAndReservationService = new TrackingSpacesAndReservationServiceImpl(); 
        TicketPaymentServiceImpl ticketPaymentService = new TicketPaymentServiceImpl();
        AuthorizationServerInterceptor authorizationServerInterceptor = new AuthorizationServerInterceptor();
        SmartParkingServerMetadataInterceptor smartParkingServerMetadataInterceptor = new SmartParkingServerMetadataInterceptor();
        
        int port = 50051;

        try{
            Server server = ServerBuilder.forPort(port)
                    .addService(vehicleEntryExitService)
                    .addService(trackingSpacesAndReservationService)
                    .addService(ticketPaymentService)
                    .intercept(authorizationServerInterceptor)
                    .intercept(smartParkingServerMetadataInterceptor)
                    .build()
                    .start();
            logger.info("Server started, listening on " + port);
            System.out.println(" Server started, listening on " + port);
            //shutdown and cancelation
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.err.println("Shutting down gRPC server");
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    logger.log(Level.WARNING, "Server could not shutdown properly.", e);
                    e.printStackTrace(System.err);
                }
            }));
            server.awaitTermination();

        } catch (IOException e) {
            logger.log(Level.WARNING, "Server failed due to IO error.", e);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Server had an interruption while being executed.", e);
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
            //making the service output it to the consele
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing entry/exit request from client: " + clientId);
            
            System.out.println("Receiving vehicle entry/exit request");
            //checking if the vehicle is leaving or entrying the parking area
            String operation = request.getOperation();
            //in case the vehicle is leaving the parking area, we need to confirm if the ticket was paid
            //for the entrance will be always true
            boolean confirmation = false;
            //generating random confirmation(true or not) for the payment to confirm the exit
            boolean paidTicket = new Random().nextBoolean();
            String message;
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
        //always start with 10 available spots and goes until 100
        int emptySpots = new Random().nextInt(91) + 10;
        List<String> reservations = new ArrayList<>();
        
        //server streaming
        @Override
        public void trackingSpots(Empty request, StreamObserver<SpotsAvailability> responseObserver) {
            //making the service output it to the consele
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing tracking spots request from client: " + clientId);
            
            System.out.println("Checking available spots");

            do {
                SpotsAvailability reply = SpotsAvailability.newBuilder().setEmptySpots(emptySpots).build();

                responseObserver.onNext(reply);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.log(Level.WARNING, "Server had a problem while trying to executing.", e);
                }

                //updating randomly according to entry or exit of vehicles
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
            //making the service output it to the consele
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing the reservation request from client: " + clientId);
            
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
                    System.out.println("Error while trying to make the reservation: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed.");
                    responseObserver.onCompleted();
                }
            };
        }
    }
    
    /*This service is a client streaming and allows the customer to pay the parking ticket
     *in as many types of payment as he wants. 
     *This service is also a unary streaming and this part requests the parking ticket and 
     *generate the price of the ticket related to it.
    */
    public static class TicketPaymentServiceImpl extends TicketPaymentServiceGrpc.TicketPaymentServiceImplBase {
        /*As there are two methods that depends on each other, to store the amount 
         *generated by the first method "randomAmount" so that it is possible for the second method
         *"processPayment" to acces this same value, it is necessary to use a Map to keep this value as a key
         *and also allow it to be shared between the methods.
        */        
        private Map<String, Double> storeAmount = new HashMap<>();
        
        @Override
        //unary 
        public void randomAmount(AmountRequest request, StreamObserver<AmountReply> responseObserver){
            //making the service output it to the consele
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing ticket payment request from client: " + clientId);

            //requesting the parking ticket ID inserted by the user
            String parkingID = request.getParkingID();
            //generating a random value to be paid that will be associated with the parking ticket 
            double min = 10;
            double max = 100;
            double price = min + Math.random() * (max - min);
            price = Math.round(price * 100.0) / 100.0;
            
            //sending it to Map collection
            storeAmount.put(parkingID, price);
            System.out.println("Parkind ID: " + parkingID + ". Amount to be paid: €" + price);
            
            //sends the information about the amount to be paid to the customer
            AmountReply reply = AmountReply.newBuilder()
                                .setParkingID(parkingID)
                                .setAmount(price)
                                .build();
            
           responseObserver.onNext(reply);
           responseObserver.onCompleted();         
        }

        @Override
        //client streaming 
        public StreamObserver<TicketPaymentRequest> processPayment(StreamObserver<TicketPaymentReply> responseObserver) {
            //making the service output it to the consele
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing ticket payment request from client: " + clientId);
            
            return new StreamObserver<TicketPaymentRequest>() {
                double expectedAmount = 0;
                double paid = 0;
                String receiptID;
                String message = "";
                String parkingID ="";
                boolean confirmation = false;                
                boolean startPayment = true;
                

                @Override
                public void onNext(TicketPaymentRequest request) {
                    double amount = request.getAmount();
                    String typePayment = request.getPaymentType();
                    
                    //initializes the total amount on the first payment
                    if(startPayment){ 
                        //taking the parkingID inserted by the user
                        parkingID = request.getParkingID();
                        if(storeAmount.containsKey(parkingID)){
                            expectedAmount = storeAmount.get(parkingID);
                            startPayment = false;
                            System.out.println("Initialing payment service.");
                        }else{
                            message = "Parking ticket has not been found.";
                            System.out.println(message);
                            responseObserver.onError(new IllegalArgumentException(message));
                            return;                                     
                        }
                    }
                   
                    //checking if the amount tried to pay by card or voucher exceeds the real amount
                    double remaining = expectedAmount - paid;
                    remaining = Math.round(remaining * 100.0)/100.0;
                    if (!typePayment.equals("Cash") && amount > remaining) {
                        message = "Invalid amount for the payment type: " + typePayment + ".";
                        System.out.println(message);
                        responseObserver.onError(new IllegalArgumentException(message));
                        return;
                    }
               
                    //checking how much was paid and comparing with the total amount
                    paid += amount;
                    paid = Math.round(paid * 100.0) / 100.0;
                    
                    System.out.println("Paid €: " + request.getAmount() + ". Payment type: " + request.getPaymentType());   
                }
                    
                @Override
                public void onError(Throwable t) {
                    System.out.println("Error receiving payment: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    receiptID = UUID.randomUUID().toString();
                    
                    //verifying if the paid amount is exactly as the one generated previously
                    if(Double.compare(paid, expectedAmount) == 0){
                        confirmation = true;
                        message = "Payment done. Total: Receipt ID: " + receiptID;
                        //removes the value generated from the Map
                        storeAmount.remove(parkingID);
                    }else{
                        confirmation = false;
                        message = "Payment failed.";
                    }
                    
                    System.out.println(message);
                    
                    TicketPaymentReply reply = TicketPaymentReply.newBuilder()
                            .setConfirmation(confirmation)
                            .setReceiptID(receiptID)
                            .build();
                    responseObserver.onNext(reply);
                    
                    //only ends based on the payment
                    //payment needs to be equals to the amount settled 
                    if(confirmation){
                        responseObserver.onCompleted();
                    }else{
                        responseObserver.onError(new IllegalArgumentException(message));
                    }
                }
            };
        } 
    }
}