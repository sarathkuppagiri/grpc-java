package com.dagli.grpcclient.grpc.interceptor;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.MethodDescriptor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;


@GrpcGlobalClientInterceptor
@Slf4j
public class AuthTokenProvideInterceptor implements ClientInterceptor {

    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, final CallOptions callOptions, final Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(final Listener<RespT> responseListener, final Metadata headers) {
            	System.out.println("interceptCall client....");
                headers.put(Key.of("auth_token", Metadata.ASCII_STRING_MARSHALLER), "valid_token");
                super.start(responseListener, headers);
            }
        };
    }
}
