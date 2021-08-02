package com.green.chodoori.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.main.web.domain.LoginForm;
import com.green.chodoori.main.web.domain.SessionUserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexAndLoginController {

	@GetMapping
	public String IndexGetter() {
		log.info("인덱스 페이지 유청 수신");
		return "index";
	}
	
	@PostMapping("/login")
	public String loginRequestedDataValidation(@ModelAttribute LoginForm form, HttpServletRequest req, @CookieValue(name = "JSESSIONID")Cookie sessionId) {
	
		
		log.info("새로운 유저가 로그인을 시도함 : {}",form.toString());
		
		//유저정보와 데이터베이스 정보 조회해서 비교하는 로직 넣기
		
		boolean test= true;
		
		if(test) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(60*30);
			session.setAttribute(sessionId.getValue(), new SessionUserInfo(null,null,null));
			//세션 생성 및, 세션에 로그인 정보 삽입.
			
			log.info("{}가 로그인 시도에 성공함.",form.getId());
			
			log.info("session 정보"
					+ "세션 아이디 : {}"
					+ "쿠키 아이디 : {}",session.getId(),sessionId.getValue());
			
			
			return "redirect:/";
		}else {
			
			log.info("{}가 로그인 시도에 실패함 에러 페이지를 띄운다.",form.getId());

			return "redirect:/?error";
		}
	}
	
}
