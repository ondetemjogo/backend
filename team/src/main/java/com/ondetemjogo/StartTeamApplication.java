package com.ondetemjogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ondetemjogo")
public class StartTeamApplication {

   public static void main(String[] args) {
      SpringApplication.run(StartTeamApplication.class, args);
   }

}
