package com.sarath.grpcclient.grpc;

import org.springframework.stereotype.Component;

import com.sarath.calculator.CalculatorServiceGrpc;
import com.sarath.calculator.Input;

import io.grpc.stub.StreamObserver;
import lombok.Setter;
import net.devh.boot.grpc.client.inject.GrpcClient;

/**
 * Configuration of SpringGrpcServerClient
 */
@Component
@Setter
public class SpringGrpcServerClient {

	@GrpcClient("springgrpcserver")
	private CalculatorServiceGrpc.CalculatorServiceStub calculatorServiceBlockingStub;

	/**
	 * Method calling hello method from SpringGrpcServer service.
	 */
	public String sum() {

		StreamObserver<Input> inputStreamObserver = this.calculatorServiceBlockingStub
				.sumAll(new OutputStreamObserver());

		for (int i = 0; i <= 100; i++) {
			// build the request object
			Input input = Input.newBuilder().setNumber(i).build();
			// pass the request object via input stream observer
			inputStreamObserver.onNext(input);
		}

		// client side is done. this method make the server respond with the sum value
		inputStreamObserver.onCompleted();

		// just for testing
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "SUCCESS";

	}

}
