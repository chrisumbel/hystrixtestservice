package com.cloudnativedotnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCircuitBreaker
public class TestserviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TestserviceApplication.class, args);
	}
}
