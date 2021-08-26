package com.green.chodoori;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.chodoori.temp.Mail;
import com.green.chodoori.temp.MimeTypeMailService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TestController {

	private final MimeTypeMailService mimeservice;
	
	@ResponseBody
	@GetMapping("/test-mail")
	public String mailTest() throws MessagingException {
		mimeservice.mailSend("");
		return "ok";
	}
}
