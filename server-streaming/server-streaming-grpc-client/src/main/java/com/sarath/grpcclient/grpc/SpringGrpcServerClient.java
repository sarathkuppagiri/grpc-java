package com.sarath.grpcclient.grpc;

import org.springframework.stereotype.Component;

import com.sarath.ecommerce.Category;
import com.sarath.ecommerce.ECommerceServiceGrpc.ECommerceServiceBlockingStub;
import com.sarath.ecommerce.OrderRequest;

import lombok.Setter;
import net.devh.boot.grpc.client.inject.GrpcClient;

/**
 * Configuration of SpringGrpcServerClient
 */
@Component
@Setter
public class SpringGrpcServerClient {

	@GrpcClient("springgrpcserver")
	private ECommerceServiceBlockingStub eCommerceServiceBlockingStub;

	/**
	 * Method calling hello method from SpringGrpcServer service.
	 */
	public String placeOrder() {
		OrderRequest electronic = OrderRequest.newBuilder().setOrderCategory(Category.ELECTRONICS).build();
		this.eCommerceServiceBlockingStub.placeOrder(electronic)
				.forEachRemaining(item -> System.out.println(item.getOrderStatus()));
		return "SUCCESS";

	}

}
