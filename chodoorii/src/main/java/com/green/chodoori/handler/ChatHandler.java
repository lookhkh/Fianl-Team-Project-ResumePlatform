package com.green.chodoori.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Repository
@Slf4j			//2.웹소켓 핸들러
public class ChatHandler extends TextWebSocketHandler {
	
	private static List<WebSocketSession> list = new ArrayList<>();
	
	private static Map<String, WebSocketSession> userSession = new HashMap<>();
	//1:1메세지
	@Autowired
	HttpSession hs;
	
	@Autowired
	CorporateDetailDtoRepo repo;
	
	//메세지
	@Override
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception{
		String payload = message.getPayload();//자바스크립트로부터 넘어온 메세지
		//paylod - 전송되는 데이터를 의미 데이터를 전송시 다양한 요소들을
		//함께 보내 데이터 전송 효율과 안전성을 높히게 된다.보내고자하는 데이터 자체를 페이로드라고 한다.
		log.info("payload : "+payload);
		for(WebSocketSession sess:list) {
			sess.sendMessage(message);
		}
//		log.info("msg : {}",msg);
//		if(msg !=null) {
//			String[] msgs = msg.split(",");
//			if(msg != null && msgs.length==1) {
//				String receiver = msgs[0];//작성자
//				String id = msgs[1];//0이면 좋아요 취소, 1이면 좋아요
//
//				String mid = currentUserName(session);
//				WebSocketSession receiversession = userSession.get(receiver);//받는 사람은 적속중인가?
//				if(receiversession !=null) {
//					TextMessage txtmsg = new TextMessage(mid +"님이 이력서를 보냈습니다.");
//					receiversession.sendMessage(txtmsg);//메세지를 작성자에게 보내기
//				}else {
//					TextMessage txtmsg = new TextMessage(receiver+"님에게 성공적으로 이력서를 보냈습니다.");
//					//보내진것 체크하기
//				}
//			}
//		}
	}

	private String currentUserName(WebSocketSession session) {
		String mid = session.getPrincipal().getName();
		return mid;
	}

	//Client 접속
	@Override
	public void afterConnectionEstablished(WebSocketSession session)throws Exception{
		list.add(session);
		log.info("클라이언트 접속 = {}",session);
	}
	//Client 접속 해제
	@Override
	public void afterConnectionClosed(WebSocketSession session,CloseStatus status)throws Exception{
		System.out.println("afterConnectionEstablished:" + session + ":" + status);
		list.remove(session);
		}
}
