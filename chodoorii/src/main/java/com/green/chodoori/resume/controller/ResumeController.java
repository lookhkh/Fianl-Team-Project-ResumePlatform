package com.green.chodoori.resume.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.chodoori.error.ResumeNotFoundError;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;
import com.green.chodoori.resume.domain.SharedMyResumeInfoDto;
import com.green.chodoori.resume.domain.SharedMyResumeInfoDtoRepo;
import com.green.chodoori.util.mail.MailService;

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
	
	@Autowired
	SharedMyResumeInfoDtoRepo smRepo;
	
	@Autowired
	MailService mail;
	
	
	@GetMapping("/display")
	public String displayMyResume(HttpSession session,Model model) {
		
		
		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);
		
		Optional<ResumeDto> resume = resumeRepo.findById(sessionInfo.getId());
		
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
		
		Optional<ResumeDto> resume = resumeRepo.findById(sessionInfo.getId());

		resumeRepo.delete(resume.get());
		
		userRepo.findById(sessionInfo.getId()).get().setCheck_detail(1);
		
		sessionInfo.setCheck(1);
		
		session.setAttribute("userInfo", sessionInfo);
		
		
		
		return "redirect:/resume/";
	}
	
	@GetMapping("/edit")
	public String editMyResume(HttpSession session) {

		return "/resume/resumeChoice";
		
	}
	
	@GetMapping("/share")
	public String shareForm() {
		log.info("공유 페이지 호출");
		return "/resume/resumeShare";
	}
	
	@PostMapping("/share/mail")
	public String shareMyResumeByEmail(@RequestParam("to")String to, @RequestParam("what")String what, HttpSession session) throws UnsupportedEncodingException {
		
		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);
		
		
		SharedMyResumeInfoDto myInfo = new SharedMyResumeInfoDto();
		
		myInfo.setRegisterDate(new Date());
		myInfo.setUserInfoDto(userRepo.getById(sessionInfo.getId()));
		
		
		System.out.println(to);
		System.out.println(what);

		
		mail.sendMailForSharingMyResume(to, what, sessionInfo.getId());
		
		
		smRepo.save(myInfo);
		
		return "redirect:/resume?share=on";
		
		//메일 보내기 기능 넣기.
	}
	
	@GetMapping("/share/mail/{userId}")
	public String displayMyResumeByEmail(@PathVariable String userId, Model model) throws UnsupportedEncodingException {
		System.out.println(userId);

		ResumeDto myInfo = resumeRepo.findById("test1234").get();
		String templateKind = "/resume/template/templateSample"+myInfo.getTemplate_kind();
		model.addAttribute("resume",myInfo);

		
		return templateKind;
	}
	
}
