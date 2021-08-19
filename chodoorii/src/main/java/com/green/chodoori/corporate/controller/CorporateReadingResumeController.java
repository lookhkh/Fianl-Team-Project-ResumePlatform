package com.green.chodoori.corporate.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.error.ResumeNotFoundError;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.service.LoginService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class CorporateReadingResumeController {
	
	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@Autowired
	ResumeDtoRepo Repo;
	
	@Autowired
	UserInfoRepo UserRepo;
	
	@Autowired
	LoginService service;
	
	@GetMapping("/lists")
	public String ViewResume(@PageableDefault(page = 0,size = 5)Pageable pageable, Model model,HttpSession session) {
		Page<ResumeDto> dto = Repo.findAll(pageable);
		SessionUserInfo user = sessionExtractor.extractSessionUserInfo(session);
		Integer Sort = user.getSort();
		log.info("SortNum=={}",Sort);
		model.addAttribute("dto",dto);
		if(Sort.equals(0)) {
			return "/resume/resumeList";
		}else if(Sort.equals(1)) {
			return "corporate/resume";
		}else {
		return "/resume/resumeRegistration";
		}
	}
	@GetMapping("/display/{id}")
	public String selectresume(@PathVariable String id,Model model,HttpSession session) {
		Optional<ResumeDto> dto = Repo.findById(id);
		
		Optional<ResumeDto> resume = Repo.findById(id);
		if(!dto.isPresent()) {
			throw new ResumeNotFoundError("요청하신 이력서정보가 존재하지 않습니다");
		}
		String templateNumber = resume.get().getTemplate_kind();
		String template = "/resume/template/templateSample" + templateNumber;

		model.addAttribute("dto",dto);
		return template;
	}
}	

