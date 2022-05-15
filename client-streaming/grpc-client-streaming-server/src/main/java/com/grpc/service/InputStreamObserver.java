package com.grpc.service;

import com.sarath.calculator.Input;
import com.sarath.calculator.Output;

import io.grpc.stub.StreamObserver;

public class InputStreamObserver implements StreamObserver<Input> {

	private int sum = 0;
	private final StreamObserver<Output> outputStreamObserver;

	public InputStreamObserver(StreamObserver<Output> outputStreamObserver) {
		this.outputStreamObserver = outputStreamObserver;
	}

	@Override
	public void onNext(Input input) {
		System.out.println("input...."+input);
		sum = sum + input.getNumber();
	}

	@Override
	public void onError(Throwable throwable) {

	}

	@Override
	public void onCompleted() {
		Output output = Output.newBuilder().setResult(sum).build();
		outputStreamObserver.onNext(output);
		outputStreamObserver.onCompleted();
	}

}
