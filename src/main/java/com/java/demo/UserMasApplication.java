package com.java.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.java.demo")
public class UserMasApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMasApplication.class, args);
		System.out.print("Server started.");
	}
}
