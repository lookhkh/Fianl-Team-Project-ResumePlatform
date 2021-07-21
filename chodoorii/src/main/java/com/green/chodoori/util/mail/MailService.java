package com.green.chodoori.util.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailService {
	
	   @Autowired
	   private JavaMailSender mailSender;
	   private HashMap<String, MailAuthInfoDto> store;
	   
	   public MailService() {
		   this.store=new HashMap();
	   }
	   
	   


	   public HashMap<String, MailAuthInfoDto> getStore() {
		return store;
	}




	private static final String FROM_ADDRESS = "lookhkh37@gmail.com";

	   	@ExceptionHandler(Exception.class)
	   	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	   	public String emailErrorHandler(Exception ex) {
	   		return "알 수 없는 오류가 발생했습니다";
	   	}
	   
	   
	    public void mailSend(String address, HttpSession session) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(address);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("인증정보");

	        

	        String random = randomNumberGenerator();
	        
	        message.setText("인증번호 : "+random);

	        
	        MailAuthInfoDto dto = new MailAuthInfoDto(random);

	   
 
	       // session.setAttribute("auth", dto);
	        store.put("auth", dto);
	        
	        mailSender.send(message);
	        
	        
	    }
	    

	    
	    public String randomNumberGenerator() {
	    	Random rd = new Random();
	    	String randomNum = "";
	    	
	    	for(int i=0; i<6; i++) {
		    	randomNum+=rd.nextInt(10);
	    	}
	    	
	    	return randomNum;
	    }
	    
	}


