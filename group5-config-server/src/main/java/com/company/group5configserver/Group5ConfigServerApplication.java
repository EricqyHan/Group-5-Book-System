package com.company.group5configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Group5ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group5ConfigServerApplication.class, args);
	}

}
