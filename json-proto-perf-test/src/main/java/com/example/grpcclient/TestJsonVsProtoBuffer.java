package com.example.grpcclient;

import com.example.grpcserver.hello.HelloRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJsonVsProtoBuffer {

	public static void main(String[] args) throws Exception {

		Runnable r1 = () -> {
			JHello hello = new JHello();
			hello.setFirstName("Sarath");
			hello.setLastName("Kuppagiri");
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				byte[] bytes = objectMapper.writeValueAsBytes(hello);

				JHello jHello = objectMapper.readValue(bytes, JHello.class);
			} catch (Exception e) {
				// TODO: handle exception
			}
		};

		Runnable r2 = () -> {
			JHello hello = new JHello();
			hello.setFirstName("Sarath");
			hello.setLastName("Kuppagiri");
			try {
				HelloRequest helloRequest = HelloRequest.newBuilder().setFirstName("Sarath").setLastName("Kuppagiri")
						.build();
				byte[] byteArr = helloRequest.toByteArray();

				HelloRequest helloRequest1 = HelloRequest.parseFrom(byteArr);
			} catch (Exception e) {
				// TODO: handle exception
			}
		};
		for (int i = 0; i < 5; i++) {
			performanceTest(r1, "JSON");
			performanceTest(r2, "PROTO");
		}

	}

	private static void performanceTest(Runnable runnable, String method) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			runnable.run();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(method + " : " + (endTime - startTime) + " ms");
	}

}
