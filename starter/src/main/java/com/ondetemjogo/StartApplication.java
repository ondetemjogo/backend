package com.ondetemjogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.ondetemjogo.StartEventApplication;
import com.ondetemjogo.StartNewEventApplication;

@SpringBootApplication
@ComponentScan(basePackages = "com.ondetemjogo", 
excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {StartEventApplication.class, StartNewEventApplication.class})) 
public class StartApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApplication.class, args);
    }

}