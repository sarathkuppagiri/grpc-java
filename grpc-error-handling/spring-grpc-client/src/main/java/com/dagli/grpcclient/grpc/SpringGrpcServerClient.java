package com.dagli.grpcclient.grpc;

import org.springframework.stereotype.Component;

import com.vinsguru.calculator.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import com.vinsguru.calculator.Request;
import com.vinsguru.calculator.Response;

import lombok.Setter;
import net.devh.boot.grpc.client.inject.GrpcClient;

/**
 * Configuration of SpringGrpcServerClient
 */
@Component
@Setter
public class SpringGrpcServerClient {

	@GrpcClient("springgrpcserver")
	private CalculatorServiceBlockingStub calculatorServiceBlockingStub;

	/**
	 * Method calling hello method from SpringGrpcServer service.
	 */
	public String hello(String name) {
		Response response = calculatorServiceBlockingStub.findSquare(Request.newBuilder().setNumber(-10).build());

		switch (response.getResponseCase()) {
		case SUCCESS_RESPONSE:
			System.out.println("Success Response : " + response.getSuccessResponse().getResult());
			break;
		case ERROR_RESPONSE:
			System.out.println("Error Response : " + response.getErrorResponse().getErrorCode());
			break;
		}
		return "SUCCESS";
	}

}
