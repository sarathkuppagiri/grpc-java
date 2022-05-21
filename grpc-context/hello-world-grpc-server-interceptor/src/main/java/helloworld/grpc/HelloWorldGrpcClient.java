package helloworld.grpc;

import helloworld.GreeterGrpc;
import helloworld.Helloworld.HelloReply;
import helloworld.Helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldGrpcClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

		GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
		HelloReply helloResponse = stub.sayHello(HelloRequest.newBuilder().setName("Sarath").build());
		System.out.println("hello reply response : "+ helloResponse.getMessage());
		channel.shutdown();

	}

}
