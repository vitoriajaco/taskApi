package com.example.apigenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.apigenerator")
public class ApigeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigeneratorApplication.class, args);
	}

}
