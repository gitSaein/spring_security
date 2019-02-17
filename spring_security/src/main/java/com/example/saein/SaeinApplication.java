package com.example.saein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SaeinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaeinApplication.class, args);
	}

}

