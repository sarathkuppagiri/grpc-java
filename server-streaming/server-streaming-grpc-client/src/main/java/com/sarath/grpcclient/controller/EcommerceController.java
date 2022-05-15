package com.sarath.grpcclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarath.grpcclient.grpc.SpringGrpcServerClient;

import lombok.RequiredArgsConstructor;

/**
 * Controller for testing gRPC communication.
 */
@RestController
@RequestMapping("/api/v1/grpc/serverstreaming")
@RequiredArgsConstructor
public class EcommerceController {

	@Autowired
	private SpringGrpcServerClient springGrpcServerClient;

	@GetMapping("/placeOrder")
	public String palceOrfer() {
		return springGrpcServerClient.placeOrder();
	}

}
