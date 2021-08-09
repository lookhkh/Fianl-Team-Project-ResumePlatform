package com.green.chodoori.resume.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.error.ResumeNotFoundError;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.IntroductionDto;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;
import com.green.chodoori.resume.domain.SkillSetDto;
import com.green.chodoori.resume.domain.SnsAddressDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@Autowired
	UserInfoRepo userRepo;
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	@GetMapping("/display")
	public String displayMyResume(HttpSession session,Model model) {
		
		
		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);
		String userId = sessionInfo.getId();
		
		Optional<ResumeDto> resume = resumeRepo.findById(userId);
		
		if(resume.isPresent()) {
			
			String templateNumber = resume.get().getTemplate_kind();
			String template = "/resume/template/templateSample"+templateNumber;
			
			log.info("템플릿 종류 : {}",template);
			
			model.addAttribute("resume",resume.get());
			
			return template;
			
		}else {
			throw new ResumeNotFoundError("이력서가 존재하지 않습니다");
		}


		
	}
	
	@GetMapping("/remove")
	@Transactional
	public String removeMyResume(HttpSession session) {
		
		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);
		String userId = sessionInfo.getId();
		
		Optional<ResumeDto> resume = resumeRepo.findById(userId);

		resumeRepo.delete(resume.get());
		
		userRepo.findById(userId).get().setCheck_detail(1);
		
		sessionInfo.setCheck(1);
		
		session.setAttribute("userInfo", sessionInfo);
		
		
		
		return "redirect:/resume/";
	}
	
	@GetMapping("/edit")
	public String editMyResume(HttpSession session) {

		return "/resume/resumeChoice";
		
	}
	

	
}
