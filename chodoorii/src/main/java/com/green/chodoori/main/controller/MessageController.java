package com.green.chodoori.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.green.chodoori.main.domain.AlramDto;

@Controller
public class MessageController {
		@Autowired
		private SimpMessagingTemplate templet;
		
	    @MessageMapping("/share")
	    public void getPrivateMessage(AlramDto alram) {
	    	
	    	System.out.println("도착했습니다."+alram.getFromwhom());
	    	templet.convertAndSend("/topic/alram/"+alram.getTowhom(),alram.getFromwhom()+"님이 이력서를 보냈습니다.");
	    	//해당 Configuer의 (/topic)api를 구독하고 있는 클라이언트에게 메세지 전달
	    	//DTO 변경시 에러있음
	    }
	}