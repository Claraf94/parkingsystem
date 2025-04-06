/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.logging.Logger;
import grpc.generated.VehicleEntryExit.ClientRequest;
import grpc.generated.VehicleEntryExit.ClientReply;
import grpc.generated.VehicleEntryExit.VehicleEntryExitServiceGrpc.VehicleEntryExitServiceImplBase;
import grpc.generated.TrackingSpacesAndReservation.SpotsAvailability;
import grpc.generated.TrackingSpacesAndReservation.TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.Random;

public class SmartParkingServer{

    private static final Logger logger = Logger.getLogger(SmartParkingServer.class.getName());

    public static void main(String[] args) {
        
        VehicleEntryExitServiceImpl vehicleEntryExitService = new VehicleEntryExitServiceImpl(){};
        TrackingSpacesAndReservationServiceImpl trackingSpacesAndReservationService = new TrackingSpacesAndReservationServiceImpl() {};
        int port = 50051;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(vehicleEntryExitService)
                    .addService(trackingSpacesAndReservationService)
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
        public void performingVehicleEntryExit (ClientRequest request, StreamObserver<ClientReply> responseObserver) {

            System.out.println("Receiving vehicle entry/exit request");
            
            //in case the vehicle is leaving the parking area, we need to confirm if the ticket was paid
            //for the entrance will be always true
            boolean confirmation = false;
            //checking if the vehicle is leaving or entrying the parking area
            String operation = request.getOperation();
            //generating random confirmation(true or not) for the payment
            boolean paidTicket = new Random().nextBoolean();
            
            if("Entry".equals(operation)){
                System.out.println("Vehicle entry number plate: " + request.getNumberPlate());
                confirmation = true;
            }else{
                System.out.println("Vehicle exit number plate: " + request.getNumberPlate());
                if(paidTicket){
                    confirmation = true;
                    System.out.println("Ticket was paid.");
                }else{
                    confirmation = false;
                    System.out.println("Ticket wasn't paid.");
                }
            }

            ClientReply reply = ClientReply.newBuilder().setMessage("Vehicle number plate: " + request.getNumberPlate() + ".\nOperation: " + request.getOperation()).setConfirmation(confirmation).build();

            responseObserver.onNext(reply);

            responseObserver.onCompleted();
        }
    }
    
    /*
    *
    *This service is a service streaming and returns information about available spots to park 
    */
    public static class TrackingSpacesAndReservationServiceImpl extends TrackingSpacesAndReservationServiceImplBase {
        @Override
        public void trackingSpots(Empty request, StreamObserver<SpotsAvailability> responseObserver){

            System.out.println("Checking available spots"); 

            //generating random number of spots available for parking
            Random random = new Random();
            int emptySpots = random.nextInt(11);


            do{            
                SpotsAvailability reply = SpotsAvailability.newBuilder().setEmptySpots(emptySpots).build();

                responseObserver.onNext(reply);

                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                //updating according to entry or exit of vehicles
                int operation = random.nextInt(2);
                int update = 0;

                switch(operation){
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

            }while(emptySpots > 0 && emptySpots <= 10);

            System.out.println("No more spots available for parking.");
            responseObserver.onCompleted();
        }
    }       
}
