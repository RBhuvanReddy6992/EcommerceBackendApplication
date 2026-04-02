package com.ecommerce.Order_Servcie;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecommerce")
public class OrderServiceApplication {

    public static void main(String[] args) {
    	System.out.print("Befor starting --------------------------------------------------");
        SpringApplication.run(OrderServiceApplication.class, args);
        System.out.print("After Starting --------------------------------------------------");
    }
}
