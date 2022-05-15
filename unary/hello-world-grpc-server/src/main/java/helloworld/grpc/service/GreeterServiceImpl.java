package helloworld.grpc.service;

import helloworld.GreeterGrpc.GreeterImplBase;
import helloworld.Helloworld.HelloReply;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreeterServiceImpl extends GreeterImplBase {

	@Override
	public void sayHello(helloworld.Helloworld.HelloRequest request,
			io.grpc.stub.StreamObserver<helloworld.Helloworld.HelloReply> responseObserver) {
		log.info("sayHello...");
		String message = new StringBuilder().append("Hello, ").append(request.getName()).toString();

		HelloReply response = HelloReply.newBuilder().setMessage(message).build();
		log.info("response...");
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
