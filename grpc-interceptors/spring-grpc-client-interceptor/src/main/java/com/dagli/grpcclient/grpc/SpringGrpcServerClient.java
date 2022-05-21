package com.dagli.grpcclient.grpc;

import org.springframework.stereotype.Component;

import helloworld.GreeterGrpc.GreeterBlockingStub;
import helloworld.Helloworld.HelloReply;
import helloworld.Helloworld.HelloRequest;
import lombok.Setter;
import net.devh.boot.grpc.client.inject.GrpcClient;

/**
 * Configuration of SpringGrpcServerClient
 */
@Component
@Setter
public class SpringGrpcServerClient {

	@GrpcClient("springgrpcserver")
	private GreeterBlockingStub helloServiceBlockingStub;

	/**
	 * Method calling hello method from SpringGrpcServer service.
	 */
	public String hello(String name) {
		HelloReply helloReply = helloServiceBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
		System.out.println("message...." + helloReply.getMessage());
		return helloReply.getMessage();
	}

}
