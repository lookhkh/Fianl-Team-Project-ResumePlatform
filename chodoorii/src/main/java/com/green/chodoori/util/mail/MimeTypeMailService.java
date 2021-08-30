package com.green.chodoori.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.repository.MainRepository;

import lombok.Data;

@Service
@Data
public class MimeTypeMailService implements MailServiceInterface  {
   
	private final JavaMailSender mailSender;
	private final String FROM_ADDRESS = "lookhkh37@gmail.com";
	private final HashMap<String, MailAuthInfoDto> store;
	private final UserInfoRepo repo;
	private final MainRepository mainRepo;
	
	
	public MimeTypeMailService(JavaMailSender mailSender,UserInfoRepo userInfo, MainRepository mainRepository) {
		super();
		this.mailSender = mailSender;
		this.store = new HashMap<String, MailAuthInfoDto>();
		this.repo = userInfo;
		this.mainRepo = mainRepository;
	}
	

    
    public void mailSend(String address) throws MessagingException {
        
    	String random = randomNumberGenerator();

    	String content = contentMaker(MailServiceType.인증정보.toString(),random);

    	MimeMessage message = mailSender.createMimeMessage();

    	MimeMessageHelper helper =  msgHelperCreator(message);
    	
    	mailSetter(address, content, helper, MailServiceType.인증정보);
    	

        MailAuthInfoDto dto = new MailAuthInfoDto(random);
        store.put("auth", dto);
        
    	mailSender.send(message);
    	
    }
    

	   public void sendMailForIdLookUp(String address, String id) throws MessagingException {

		   String content = contentMaker(MailServiceType.아이디찾기.toString(), id);
		   
		 	((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
		 	MimeMessage message = mailSender.createMimeMessage();

	    	MimeMessageHelper helper =  msgHelperCreator(message);
	    	mailSetter(address, content, helper, MailServiceType.아이디찾기);
	    	
	    	System.out.println("실행");
	    	
	    	mailSender.send(message);
	    	
	   }




	   
	   public void sendMailForPasswordLookUp(String address,String pw) throws MessagingException {
		   
		   String content = contentMaker(MailServiceType.비밀번호찾기.toString(),pw);

		   ((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
		   MimeMessage message = mailSender.createMimeMessage();

	    	MimeMessageHelper helper =  msgHelperCreator(message);
	    	
	    	mailSetter(address, content, helper , MailServiceType.비밀번호찾기);

	    	mailSender.send(message);
	    	


	   }
	   
 public void sendMailForSharingMyResume(String to, String what, String userId) throws UnsupportedEncodingException, MessagingException {
		   
		   
	
		   
		   userId = "<a href=http://localhost:8088/resume/share/mail/"+userId+">확인하기</a>";
		   
		   String content = contentMaker(what, userId);
	        
		   
		   ((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
		   MimeMessage message = mailSender.createMimeMessage();

	    	MimeMessageHelper helper =  msgHelperCreator(message);
	    	
	    	mailSetter(to, content, helper, MailServiceType.이력서공유하기);


	    	mailSender.send(message);

	   }
 
	private void mailSetter(String address, String content, MimeMessageHelper helper, MailServiceType type) throws MessagingException {
		helper.setFrom(FROM_ADDRESS);
		helper.setTo(address);
		helper.setText(content, true);
		helper.setSubject(subjectCreator(type));
	}
	
    private MimeMessageHelper msgHelperCreator(MimeMessage message) throws MessagingException {
    	((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
    	return new MimeMessageHelper(message, true);
    }
    
    
	private String randomNumberGenerator() {
    	Random rd = new Random();
    	String randomNum = "";
    	
    	for(int i=0; i<6; i++) {
	    	randomNum+=rd.nextInt(10);
    	}
    	
    	return randomNum;
    }
    
	private String contentMaker(String type, String data) {
    	
    	return  "<!DOCTYPE html>\r\n" + 
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
    			"            padding-top: 20px;\r\n" + 
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
    			"            <h1>"+type+"</h1>\r\n" + 
    			"            <div class=\"mailSendCodeBox\">\r\n" + 
    			"                <h1>"+data+"</h1>\r\n" + 
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
    			"</html>";

    	
    }
    
	private String subjectCreator(MailServiceType type) {
    	return "My Resume에서 당신을 위한 "+type.subname()+"가 도착했어요:)";
    }



}
