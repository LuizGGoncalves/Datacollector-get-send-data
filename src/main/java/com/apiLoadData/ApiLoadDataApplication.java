package com.apiLoadData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiLoadDataApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiLoadDataApplication.class, args);
	}

}
