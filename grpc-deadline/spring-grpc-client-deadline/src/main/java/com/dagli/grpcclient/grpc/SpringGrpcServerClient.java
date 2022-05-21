package com.dagli.grpcclient.grpc;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import helloworld.GreeterGrpc.GreeterBlockingStub;
import helloworld.Helloworld.HelloReply;
import helloworld.Helloworld.HelloRequest;
import io.grpc.StatusRuntimeException;
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
		try {
			HelloReply helloReply = helloServiceBlockingStub.withDeadlineAfter(1, TimeUnit.SECONDS)
					.sayHello(HelloRequest.newBuilder().setName(name).build());
			System.out.println("message...." + helloReply.getMessage());
			return helloReply.getMessage();
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

}
