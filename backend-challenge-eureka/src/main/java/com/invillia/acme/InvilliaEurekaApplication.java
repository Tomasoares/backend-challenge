package com.invillia.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InvilliaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvilliaEurekaApplication.class, args);
	}

}