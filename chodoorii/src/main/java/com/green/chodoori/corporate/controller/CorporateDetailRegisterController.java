package com.green.chodoori.corporate.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.corporate.domain.WelfareDto;
import com.green.chodoori.corporate.web.domain.CorporateDetailRegisterForm;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.service.ChangeUsersResumeStatusService;

@Controller
@RequestMapping("/corporate")
public class CorporateDetailRegisterController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@Autowired
	CorporateDetailDtoRepo corpRepo;
	
	@Autowired
	ChangeUsersResumeStatusService statusService;
	
	@GetMapping("/register")
	public String registerForm(HttpSession session, Model model) {
		
		
		
		
		SessionUserInfo user = sessionExtractor.extractSessionUserInfo(session);
		String userId = user.getId();
		
		
		if(user.getCheck()==0) {
			return "redirect:/corporate/cpinfo?error=duplicate";
		}
		
		String userName = sessionExtractor.extractUserNameFromSessionInfo(session);
		
		
		model.addAttribute("userName",userName);
		
		return "/corporate/corporateIntroduction";
	}
	
	@PostMapping("/register")
	@Transactional
	public String registerCorporateDetail(@ModelAttribute CorporateDetailRegisterForm dto, HttpSession session) {
		
		System.out.println(dto.toString());
		
		SessionUserInfo sessinInfo = sessionExtractor.extractSessionUserInfo(session);
		UserInfoDto user = sessionExtractor.extractUserInfoDtoFromSessionInfo(session);
		WelfareDto welfare = new WelfareDto();
		
		welfare.makeDto(dto.getWlfare());
		
		//검증부분 추가하기
		
		CorporateDetailDto corpDto = CorporateDetailDto.builder()
											.companayName(sessionExtractor.extractUserNameFromSessionInfo(session))
											.logo_img(sessionExtractor.extractImgPathFromSessionInfo(session))
											.userid(user)
											.staff_number(dto.getStaffNumber())
											.summary(dto.getSummary())
											.welfare(welfare)
											.build();
		
		
											
		System.out.println(corpDto.toString());
		
		
		corpRepo.save(corpDto);
		sessinInfo.setCheck(0);
		user.setCheck_detail(0);
		
		session.setAttribute("userInfo", sessinInfo);
		
		
		
		
		
		return "redirect:/corporate/cpinfo?register=on";
	}
	


}
