package com.green.chodoori.resume.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class IndexController {
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	@GetMapping
	public String resumeIndex(HttpSession session,Model model) {
		SessionUserInfo user = (SessionUserInfo)session.getAttribute("userInfo");
		
		System.out.println(user.toString());
		

		
		
		if(user.getCheck().equals(0)) {
			return "/resume/resumeList";

		}
		
		return "/resume/resumeRegistration";
	}
	
	
	
	
	
	
	
}
