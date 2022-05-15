package com.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorGrpcService {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorGrpcService.class, args);
	}
}
