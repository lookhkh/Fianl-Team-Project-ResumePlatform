package com.green.chodoori.corporate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.main.service.ExtractSessionInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/read")
public class CorporateReadingResumeController {
	
	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@GetMapping("/resume")
	public String ViewResume() {
//		Optional<Dto> dto = Repo.findAll();
		log.info("이력서 페이지 유청 수신");
		return "corporate/resume";
	}
}
