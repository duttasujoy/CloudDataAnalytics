package com.microservice.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.microservice")
@EnableAutoConfiguration

public class ProductsApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);
	}
}
