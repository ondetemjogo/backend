package com.ondetemjogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ondetemjogo")
public class TeamApplication {

   public static void main(String[] args) {
      SpringApplication.run(TeamApplication.class, args);
   }

}
