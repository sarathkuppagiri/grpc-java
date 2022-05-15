package com.sarath.grpcclient.grpc;

import java.time.LocalDateTime;

import com.sarath.ecommerce.OrderResponse;

import io.grpc.stub.StreamObserver;

public class OrderResponseStreamObserver implements StreamObserver<OrderResponse> {

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNext(OrderResponse orderResponse) {
		System.out.println(LocalDateTime.now() + " : " + orderResponse.getOrderStatus());

	}

}
