package com.green.chodoori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChodooriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChodooriApplication.class, args);
	
	}

}
