package com.green.chodoori.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.chodoori.error.PasswordIsNotSameError;
import com.green.chodoori.error.RequestedUserNotFound;
import com.green.chodoori.main.service.LoginService;
import com.green.chodoori.main.service.SessionCreateService;
import com.green.chodoori.main.web.domain.LoginForm;
import com.green.chodoori.main.web.domain.SessionUserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexAndLoginController {

	@Autowired
	LoginService service;
	
	@Autowired
	SessionCreateService sessionService;
	
	@GetMapping
	public String IndexGetter() {
		log.info("인덱스 페이지 유청 수신");
		return "index";
	}
	
	@PostMapping("/login")
	public String loginRequestedDataValidation(@ModelAttribute LoginForm form, HttpServletRequest req,@RequestParam(required = false, name="type")String type,
			@RequestParam(required = false, name="redirect")String redirect, Model model) {
	
		
		log.info("새로운 유저가 로그인을 시도함 : {}",form.toString());
		
		//유저정보와 데이터베이스 정보 조회해서 비교하는 로직 넣기
		
		
		if(service.userInfoMationCheck(form)) {
			
			
			
			sessionService.sessionCreate(form.getId(), req);
					
			if(type!=null&&type.equals("loginRedirect")) {
						
				return "redirect:"+redirect;
					}

			
			return "redirect:/?login=true";
		}

		
		return "redirect:/?error=true";
		
		
	}
	
	@GetMapping("/logout")
	public String logout(@RequestParam(defaultValue = "/") String redirect, HttpSession session) {
		session.invalidate();
		return "redirect:"+redirect;
	}
	
	@GetMapping("/abouus")
	public String getAboutUs() {
		return "main/aboutus/aboutus";
	}


}
