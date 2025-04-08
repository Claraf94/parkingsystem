/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.Logger;

import com.google.protobuf.Empty;
import grpc.generated.TrackingSpacesAndReservation.SpotsAvailability;
import grpc.generated.TrackingSpacesAndReservation.TrackingSpacesAndReservationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.logging.Level;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author dell
 */
public class SmartParkingTrackingSpaces {
    private static final Logger logger = Logger.getLogger(SmartParkingTrackingSpaces.class.getName());
    
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 50051;
        ManagedChannel channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .build();
        
        TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceStub stub;
        stub = TrackingSpacesAndReservationServiceGrpc.newStub(channel);
        try {
            // prepare to collect multiple responses from the server
            ArrayList<Integer> emptySpotsCollection = new ArrayList<Integer>();
            
            //empty request to the server
            Empty request = Empty.newBuilder().build();
            
            // prepare to receive a stream of responses from the server
            StreamObserver<SpotsAvailability> responseObserver = new StreamObserver<SpotsAvailability> () {
                @Override
                public void onNext(SpotsAvailability spotsAvailability) {
                    System.out.println("Sending updates about available parking spots: " + spotsAvailability.getEmptySpots());
                    emptySpotsCollection.add(spotsAvailability.getEmptySpots());
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Error requesting spots: " + t.getLocalizedMessage());
                }

                @Override
                public void onCompleted() {
                     System.out.println("Client received onComplete()");
                     System.out.println( "Data sent: "  + emptySpotsCollection.toString());               
                }
            };
            
            // send the request to the server on the nonblocking stub. Pass the StreamObserver to the server
            stub.trackingSpots(request, responseObserver);
        
        // print a line here to show the client continues on rather than waiting for the server response.
        System.out.println(LocalTime.now() + "Parking spots being localized");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

            return;
        } finally {
            //shutdown channel
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
