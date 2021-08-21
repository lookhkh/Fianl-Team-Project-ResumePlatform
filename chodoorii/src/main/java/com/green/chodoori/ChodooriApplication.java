package com.green.chodoori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChodooriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChodooriApplication.class, args);
	
	}
	
	@Bean 
	public MessageSource messageSource() { 
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource(); 
		messageSource.setBasenames("messages","errors"); 
		messageSource.setDefaultEncoding("UTF-8"); 
		return messageSource;  

}

}
