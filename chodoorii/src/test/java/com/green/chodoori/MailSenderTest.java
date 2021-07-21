package com.green.chodoori;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.chodoori.util.mail.MailAuthInfoDto;
import com.green.chodoori.util.mail.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MailSenderTest {


	@Autowired
	MailService service;
	
	@Test
	public void Mailtest() {
		String sampleEmail = "lookhkh37@gmail.com";
		
		HashMap<String,MailAuthInfoDto> result= service.testMailSend(sampleEmail);
		
		MailAuthInfoDto dto = result.get("authInfo");
		
		
		
		log.info("결과: {}",dto.toString());
		
	}
	

}
