package com.ondetemjogo.newevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ondetemjogo")
public class StartNewEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartNewEventApplication.class, args);
	}

}
