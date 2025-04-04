/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.generated.VehicleEntry.ClientRequest;
import grpc.generated.VehicleEntry.ClientReply;
import grpc.generated.VehicleEntry.VehicleEntryExitServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class SmartParkingClient {
    private static final Logger logger = Logger.getLogger(SmartParkingServer.class.getName());
    VehicleEntryExitServiceBlockingStub blockingStub;
    ManagedChannel channel;
   
    public SmartParkingClient (){
        String host = "localhost";
        int port = 50051;
        channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .build();
         blockingStub = GreeterGrpc.newBlockingStub(channel);
    }
}
