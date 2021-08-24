package com.green.chodoori.config;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.green.chodoori.handler.ChatHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket			//3.웹소켓 컨피그
public class WebSocketConfig implements WebSocketConfigurer{

	private final ChatHandler chatHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(chatHandler, "ws/chat")
		.addInterceptors(new HttpSessionHandshakeInterceptor())
		.setAllowedOrigins("*");
	}
}
