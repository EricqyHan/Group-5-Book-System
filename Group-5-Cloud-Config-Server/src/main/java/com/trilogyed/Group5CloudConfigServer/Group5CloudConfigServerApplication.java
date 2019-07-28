package com.trilogyed.Group5CloudConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Group5CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group5CloudConfigServerApplication.class, args);
	}

}
