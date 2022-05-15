package com.sarath.grpcclient.grpc;

import com.sarath.calculator.Output;

import io.grpc.stub.StreamObserver;

public class OutputStreamObserver implements StreamObserver<Output> {

    @Override
    public void onNext(Output output) {
        System.out.println(
                "Received : " + output.getResult()
        );
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }

}