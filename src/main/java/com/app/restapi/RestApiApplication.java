package com.app.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.restapi.services.rabbitmq.RabbitmqService;

@SpringBootApplication
public class RestApiApplication {
	public static void main(String[] args) {
		RabbitmqService.connect("events");
		SpringApplication.run(RestApiApplication.class, args);
	}

}
