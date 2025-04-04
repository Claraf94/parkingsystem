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
import grpc.generated.VehicleEntry.VehicleEntryExitServiceGrpc.VehicleEntryExitServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.logging.Level;


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
         blockingStub = VehicleEntryExitServiceGrpc.newBlockingStub(channel);
    }
    
    

    public static void main(String[]args)throws Exception{
        SmartParkingClient smartParking = new SmartParkingClient();
                try {
                    //testing for both entry and exit
                    ClientReply vehicleEntryResponse = smartParking.clientHelperVehicleEntryExit("012-D-34567", "Entry");
                    logger.info("\n" + vehicleEntryResponse.getMessage());

                    ClientReply vehicleExitResponse = smartParking.clientHelperVehicleEntryExit("012-D-34567", "Exit");
                    logger.info("\n" + vehicleExitResponse.getMessage());
                } catch (StatusRuntimeException e) {
                    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
                    return;
                }
    }

    public ClientReply clientHelperVehicleEntryExit(String numberPlate, String operation) {
        ClientRequest request = ClientRequest.newBuilder()
                    .setNumberPlate(numberPlate)
                    .setOperation(operation)
                    .build();
        ClientReply response = blockingStub.performingVehicleEntryExit(request);
        return response;
    }
}
