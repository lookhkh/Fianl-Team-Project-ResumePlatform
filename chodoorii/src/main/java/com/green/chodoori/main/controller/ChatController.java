package com.green.chodoori.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2		//4.채팅 컨트롤러 작성
public class ChatController {
	
	@GetMapping("/chat")
	public String chatGET(HttpSession session) {
		log.info(session);
		log.info("@ChatController, chat GET()");
		return "corporate/chat";
	}
}
