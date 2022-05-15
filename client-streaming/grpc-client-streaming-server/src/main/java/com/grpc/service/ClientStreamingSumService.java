package com.grpc.service;

import com.sarath.calculator.CalculatorServiceGrpc;
import com.sarath.calculator.Input;
import com.sarath.calculator.Output;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ClientStreamingSumService extends CalculatorServiceGrpc.CalculatorServiceImplBase {

	@Override
	public StreamObserver<Input> sumAll(StreamObserver<Output> responseObserver) {
		return new InputStreamObserver(responseObserver);
	}

}
