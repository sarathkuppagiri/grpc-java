package com.grpc.service;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.google.common.util.concurrent.Uninterruptibles;
import com.sarath.ecommerce.Category;
import com.sarath.ecommerce.ECommerceServiceGrpc;
import com.sarath.ecommerce.OrderRequest;
import com.sarath.ecommerce.OrderResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import static com.sarath.ecommerce.Status.*;

@GrpcService
public class EcommerceOnlineServiceImpl extends ECommerceServiceGrpc.ECommerceServiceImplBase {

	Map<Category, Consumer<StreamObserver<OrderResponse>>> categoryHandler = Map.of(Category.ELECTRONICS,
			this::handleElectronics, Category.EBOOKS, this::handleEBooks);

	@Override
	public void placeOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
		categoryHandler.get(request.getOrderCategory()).accept(responseObserver);
        responseObserver.onCompleted();
	}

	private void handleElectronics(StreamObserver<OrderResponse> responseStreamObserver) {
		Stream.of(PAYMENT_RECEIVED, SHIPPED, OUT_FOR_DELIVERY, DELIVERED)
				.map(OrderResponse.newBuilder()::setOrderStatus).map(OrderResponse.Builder::build)
				.peek(i -> Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS))
				.forEach(responseStreamObserver::onNext);
	}

	private void handleEBooks(StreamObserver<OrderResponse> responseStreamObserver) {
		Stream.of(PAYMENT_RECEIVED, DELIVERED).map(OrderResponse.newBuilder()::setOrderStatus)
				.map(OrderResponse.Builder::build).forEach(responseStreamObserver::onNext);
	}

}
