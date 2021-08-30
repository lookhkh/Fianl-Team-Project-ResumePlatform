package com.green.chodoori.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.chodoori.main.domain.AlramDto;
import com.green.chodoori.main.domain.AlramDtoRepo;
import com.green.chodoori.main.web.domain.SessionUserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SessionCreateService {
	@Autowired
	LoginService service;
	
	@Autowired
	AlramDtoRepo repo;
	
	public void sessionCreate(String userId, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		session.setMaxInactiveInterval(60*30);
		//세션 생성 및, 세션에 로그인 정보 삽입.
		
		log.info("{}가 로그인 시도에 성공함.",userId);
		
		

		SessionUserInfo sessionDto = service.createSessionUserInfoDto(userId);
		
		session.setAttribute("userInfo", sessionDto);
		
		log.info("session 생성 완료 // 세션 아이디 : {}",session.getId());
		
		List<AlramDto> dto = repo.findByTowhom(userId);
		
		session.setAttribute("Aldto", dto);
	}
}
