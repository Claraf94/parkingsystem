/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.generated.VehicleEntryExit.ClientRequest;
import grpc.generated.VehicleEntryExit.ClientReply;
import grpc.generated.VehicleEntryExit.VehicleEntryExitServiceGrpc;
import grpc.generated.VehicleEntryExit.VehicleEntryExitServiceGrpc.VehicleEntryExitServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.logging.Level;
import javax.swing.JOptionPane;


public class SmartParkingEntryExit {
        private static final Logger logger = Logger.getLogger(SmartParkingEntryExit.class.getName());
    VehicleEntryExitServiceBlockingStub blockingStub;
    ManagedChannel channel;
   
    public SmartParkingEntryExit (){
        String host = "localhost";
        int port = 50051;
        channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .build();
         blockingStub = VehicleEntryExitServiceGrpc.newBlockingStub(channel);
    }
    
    

    public static void main(String[]args)throws Exception{
        SmartParkingEntryExit smartParking = new SmartParkingEntryExit();
                try {
                    //testing for both entry and exit
                    String entrance =  JOptionPane.showInputDialog(null, "Insert the vehicle number plate: ");
                    ClientReply vehicleEntryResponse = smartParking.clientHelperVehicleEntryExit(entrance.toUpperCase(), "Entry");
                    logger.info("Entry details: " + vehicleEntryResponse.getMessage());
                    
                    String exit = JOptionPane.showInputDialog(null, "Insert the vehicle number plate: ");
                    ClientReply vehicleExitResponse = smartParking.clientHelperVehicleEntryExit(exit.toUpperCase(), "Exit");
                    logger.info("Exit details: " + vehicleExitResponse.getMessage());
                    logger.info("Payment details: " + vehicleExitResponse.getConfirmation());
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
        ClientReply responseObserver = blockingStub.performingVehicleEntryExit(request);
        return responseObserver;
    }
}
