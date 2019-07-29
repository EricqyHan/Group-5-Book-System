package com.company.group5eurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Group5EurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group5EurekaServiceRegistryApplication.class, args);
	}

}
