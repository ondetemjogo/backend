package com.ondetemjogo.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.ondetemjogo")
@ComponentScan(basePackages = "com.ondetemjogo")
public class StartEventApplication {

   public static void main(String[] args) {
      SpringApplication.run(StartEventApplication.class, args);
   }

}
