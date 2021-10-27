package com.esprit.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.esprit.microservice.controller", "com.esprit.microservice.service"})
@EntityScan("com.esprit.microservice.entity")
@EnableJpaRepositories("com.esprit.microservice.repository")
@EnableZuulProxy
public class AeroApplication {

	public static void main(String[] args) {

		SpringApplication.run(AeroApplication.class, args);
	}

}
