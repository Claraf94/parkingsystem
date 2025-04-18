/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import java.util.logging.Logger;

/*
*This classes represents the interceptor on gRPC side
*It intercept each and every data that it is requested to the server
*
*/
public class SmartParkingServerMetadataInterceptor implements ServerInterceptor{
    private static final Logger logger = Logger.getLogger(SmartParkingServerMetadataInterceptor.class.getName());
    
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        
        logger.info("Received Metadata on Server: " + headers);
        return next.startCall(call, headers);
    }
}