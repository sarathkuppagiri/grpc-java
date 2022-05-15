package com.sarath.grpcclient.grpc;

import org.springframework.stereotype.Component;

import com.sarath.gps.NavigationServiceGrpc;
import com.sarath.gps.TripRequest;

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
	private  NavigationServiceGrpc.NavigationServiceStub navigationServiceStub;

	/**
	 * Method calling hello method from SpringGrpcServer service.
	 */
	public String trip() {

		TripResponseStreamObserver tripResponseStreamObserver = new TripResponseStreamObserver();
        StreamObserver<TripRequest> requestStreamObserver = this.navigationServiceStub.navigate(tripResponseStreamObserver);
        tripResponseStreamObserver.startTrip(requestStreamObserver);
     // just for testing
        try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "SUCCESS";

	}

}
