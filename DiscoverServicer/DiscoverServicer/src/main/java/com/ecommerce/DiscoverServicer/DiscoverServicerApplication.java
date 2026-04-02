package com.ecommerce.DiscoverServicer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverServicerApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DiscoverServicerApplication.class, args);
	}

}
