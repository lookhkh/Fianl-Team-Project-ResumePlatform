package com.example.websocket.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

import com.example.websocket.domain.Content;
import com.example.websocket.domain.SocketInfo;

@Controller
public class WebSocketController {
	
	private Map<String,String> store = new HashMap<>();

	@MessageMapping("/hello/{userId}")
	@SendTo("/topic/greetings/{userId}")
	public Content greeting(SocketInfo message,@DestinationVariable String userId) throws Exception{
		
		System.out.println(userId+"에게 메시지를 송신합니다");
		
		System.out.println(message.toString());
		
		store.put(message.getFromWhom(), message.getToWhom());
		
		System.out.println(store.get(message.getFromWhom())+"로 메시지 송신");
		
		
		return new Content("Hello, "+HtmlUtils.htmlEscape(message.getFromWhom())+"!");
	}
}
