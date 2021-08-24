package com.green.chodoori.nonCorporate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.nonCorporate.domain.ResumeDtoRepo;
import com.green.chodoori.nonCorporate.repository.ResumeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class IndexController {
	

	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@GetMapping
	public String resumeIndex(HttpSession session,Model model) {
		SessionUserInfo user = sessionExtractor.extractSessionUserInfo(session);
		
		System.out.println(user.toString());
		
		
		if(user.getSort().equals(1)) {
			return "redirect:/resume/lists";
		}
		
		if(user.getCheck().equals(0)) {
			return "/resume/resumeList";

		}
		
		return "/resume/resumeRegistration";
	}
	
	
	
	
	
	
	
}
