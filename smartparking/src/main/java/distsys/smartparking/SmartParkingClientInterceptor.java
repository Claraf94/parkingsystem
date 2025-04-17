/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.logging.Logger;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class SmartParkingClientInterceptor implements ClientInterceptor {

    private static final Logger logger = Logger.getLogger(SmartParkingClientInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT>
            interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                logger.info("Added metadata");
                headers.put(Metadata.Key.of("HOSTNAME", ASCII_STRING_MARSHALLER), "MY_HOST");
                super.start(responseListener, headers);
            }
        };
    }
}
