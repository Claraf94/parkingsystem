/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.generated.VehicleEntry.ClientRequest;
import grpc.generated.VehicleEntry.ClientReply;
import grpc.generated.VehicleEntry.VehicleEntryExitServiceGrpc.VehicleEntryExitServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartParkingServer extends VehicleEntryExitServiceImplBase{

    private static final Logger logger = Logger.getLogger(SmartParkingServer.class.getName());

    public static void main(String[] args) {

        SmartParkingServer vehicleEntryExit = new SmartParkingServer();

        int port = 50051;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(vehicleEntryExit)
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

    @Override
    public void performingVehicleEntryExit (ClientRequest request, StreamObserver<ClientReply> responseObserver) {

        System.out.println("Receiving vehicle entry/exit request");
        
        ClientReply reply = ClientReply.newBuilder().setMessage("Vehicle number plate: " + request.getNumberPlate() + ".\nOperation: " + request.getOperation()).setConfirmation(true).build();

        responseObserver.onNext(reply);

        responseObserver.onCompleted();
    }

}
