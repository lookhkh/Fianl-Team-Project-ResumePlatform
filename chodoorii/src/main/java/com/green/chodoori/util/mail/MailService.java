package com.green.chodoori.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service
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
	   	private String emailErrorHandler(Exception ex) {
	   		return "알 수 없는 오류가 발생했습니다";
	   	}
	   
	   
	    public void mailSend(String address, HttpSession session) throws MessagingException {
	    	MimeMessage message = mailSender.createMimeMessage();
	    	MimeMessageHelper helper = new MimeMessageHelper(message, true);

	    	helper.setTo("lookhkh37@gmail.com");
	    	helper.setFrom(MailService.FROM_ADDRESS);
	    	helper.setSubject("인증정보");



	        // random = randomNumberGenerator();
	        
	        helper.setText("<!DOCTYPE html>\r\n" + 
	    			"<html lang=\"kr\">\r\n" + 
	    			"<head>\r\n" + 
	    			"    <meta charset=\"UTF-8\">\r\n" + 
	    			"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
	    			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
	    			"    <title>Document</title>\r\n" + 
	    			"    <style>\r\n" + 
	    			" @import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&display=swap');\r\n" + 
	    			"        body{\r\n" + 
	    			"            width: 100%;\r\n" + 
	    			"            height: 800px;\r\n" + 
	    			"            background-position: center;\r\n" + 
	    			"            background-repeat: no-repeat;\r\n" + 
	    			"            font-family: 'Gothic A1', sans-serif;\r\n" + 
	    			"        }\r\n" + 
	    			"        .mailSend{\r\n" + 
	    			"            text-align: center;\r\n" + 
	    			"            padding-top: 150px;\r\n" + 
	    			"            \r\n" + 
	    			"        }\r\n" + 
	    			"\r\n" + 
	    			"        .mailSendCodeBox{\r\n" + 
	    			"            display: inline-block;\r\n" + 
	    			"            width: 200px;\r\n" + 
	    			"            height: 100px;\r\n" + 
	    			"            background-color: gray;\r\n" + 
	    			"            border-radius:50px;\r\n" + 
	    			"            text-align: center;\r\n" + 
	    			"            \r\n" + 
	    			"        }\r\n" + 
	    			"\r\n" + 
	    			"        B{\r\n" + 
	    			"            color: blue;\r\n" + 
	    			"        }\r\n" + 
	    			"        .wrapper{\r\n" + 
	    			"            position: relative;\r\n" + 
	    			"            \r\n" + 
	    			"        }\r\n" + 
	    			"        .background{\r\n" + 
	    			"            position: absolute;\r\n" + 
	    			"            z-index: 2;\r\n" + 
	    			"            left: 400px;\r\n" + 
	    			"        }\r\n" + 
	    			"\r\n" + 
	    			"        .mailcontent{\r\n" + 
	    			"            z-index: 3;\r\n" + 
	    			"            position: absolute;\r\n" + 
	    			"            top: 110px;\r\n" + 
	    			"            left: 680px;\r\n" + 
	    			"        }\r\n" + 
	    			"\r\n" + 
	    			"    </style>\r\n" + 
	    			"</head>\r\n" + 
	    			"<body>\r\n" + 
	    			"\r\n" + 
	    			"<div class=\"wrapper\">\r\n" + 
	    			"\r\n" + 
	    			"    <div class=\"background\">\r\n" + 
	    			"    </div>\r\n" + 
	    			"    <div class=\"mailcontent\">\r\n" + 
	    			"        <div class=\"mailSend\">\r\n" + 
	    			"            <h1>이메일 인증코드</h1>\r\n" + 
	    			"            <p>아래의 인증코드를 <B><a href='http://localhost:8088'>My Resume</a></B> 홈페이지 인증코드 입력란에 입력해주세요.</p>\r\n" + 
	    			"            <div class=\"mailSendCodeBox\">\r\n" + 
	    			"                <h1>"+"</h1>\r\n" + 
	    			"            </div>\r\n" + 
	    			"            <p>정형적인 이력서가 아닌 나만의 이력서를 갖고싶다면 <B>My Resume</B><br>\r\n" + 
	    			"               능력있는 개발자를 채용하고 싶으시다면 <B>My Resume</B><br>\r\n" + 
	    			"            </p>\r\n" + 
	    			"            <h6>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.<br>\r\n" + 
	    			"                <B>My Resume</B> || Developer조둘이 || 남들과 다른 나만의 이력서 <B>My Resume</B> </h6>\r\n" + 
	    			"    \r\n" + 
	    			"    \r\n" + 
	    			"        </div>\r\n" + 
	    			"    </div>\r\n" + 
	    			"        \r\n" + 
	    			"        \r\n" + 
	    			"    \r\n" + 
	    			"</div>\r\n" + 
	    			" \r\n" + 
	    			"</body>\r\n" + 
	    			"</html>");

	        
	       // MailAuthInfoDto dto = new MailAuthInfoDto(random);

	   
 
	       // session.setAttribute("auth", dto);
	        //store.put("auth", dto);
	        
	        mailSender.send(message);
	        
	        
	    }
	    
	   public void sendMailForIdLookUp(String email, String id) {
		   SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("아이디 찾기");
	        message.setText("찾고자 하는 아이디 : "+id);
	        

	        
	        mailSender.send(message);


	   }
	   
	   public void sendMailForPasswordLookUp(String email,String id ,String pw) {
		   SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("비밀번호 찾기");
	        message.setText(
	        		"ID : "+id+
	        		"찾고자 하는 비밀번호 : "+pw);
	        
	        
	        mailSender.send(message);


	   }
	   
	   public void sendMailForSharingMyResume(String to, String what, String userId) throws UnsupportedEncodingException {
		   
		   
	
		   
		   userId = "http://localhost:8088/resume/share/mail/"+userId;
		   
		   SimpleMailMessage message = new SimpleMailMessage();
	        
		   
		   message.setTo(to);
	        message.setFrom(MailService.FROM_ADDRESS);
	        message.setSubject("MyResume로부터 이력서 열람 요청이 도착하였습니다");
	        message.setText(what+"/////"+userId);
	        

	        
	        mailSender.send(message);


	   }
	   
	    

	    
	  
	    
	}


