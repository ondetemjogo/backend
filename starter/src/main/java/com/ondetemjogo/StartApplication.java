package com.ondetemjogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.ondetemjogo", excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
		StartEventApplication.class, StartNewEventApplication.class, StartTeamApplication.class }))
public class StartApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartApplication.class, args);
	}

}