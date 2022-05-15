package com.grpc.service;

import com.sarath.gps.NavigationServiceGrpc;
import com.sarath.gps.TripRequest;
import com.sarath.gps.TripResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class NavigationService  extends NavigationServiceGrpc.NavigationServiceImplBase {

	 @Override
	    public StreamObserver<TripRequest> navigate(StreamObserver<TripResponse> responseObserver) {
	        return new TripRequestObserver(responseObserver);
	    }

}
