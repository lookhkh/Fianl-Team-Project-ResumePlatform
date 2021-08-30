package com.green.chodoori.corporate.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.repository.CorporateRepo;
import com.green.chodoori.corporate.web.domain.CorporateDetailRegisterForm;
import com.green.chodoori.corporate.web.domain.WelfareDto;
import com.green.chodoori.developer.service.ChangeUsersResumeStatusService;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;

@Controller
@RequestMapping("/corporate")
public class CorporateDetailRegisterController {


	@Autowired
	CorporateRepo corpRepo;
	
	@Autowired
	ExtractSessionInfoService sessionExtractor;

	@Autowired
	ChangeUsersResumeStatusService statusService;
	
	@GetMapping("/register")
	public String getRegisterForm(HttpSession session, Model model) {
		
		SessionUserInfo user = sessionExtractor.extractSessionUserInfo(session);
		String userId = user.getId();
		
		
		if(user.getCheck()==0) {
			model.addAttribute("director","duplicate");
			return "redirect:/corporate/cpinfo?error=duplicate";
		}
		
		String userName = sessionExtractor.extractUserNameFromSessionInfo(session);
		
		
		model.addAttribute("userName",userName);
		
		return "/corporate/corporateIntroduction";
	}
	
	@GetMapping("/delete")
	public String deleteCorporateDetail(HttpSession session) {
		SessionUserInfo sessinInfo = sessionExtractor.extractSessionUserInfo(session);
		
		
		UserInfoDto user = sessionExtractor.extractUserInfoDtoFromSessionInfo(session);
		
		sessinInfo.setCheck(1);
		user.setCheck_detail(1);
		session.setAttribute("userInfo", sessinInfo);

		//리팩토링하기
		corpRepo.deleteCorporDetail(sessinInfo.getId());
		
		
		
		
		return "redirect:/corporate/cpinfo";
		
		
	}
	
	@PostMapping("/register")
	@Transactional
	public String registerCorporateDetail(@Validated @ModelAttribute CorporateDetailRegisterForm dto, BindingResult error, HttpSession session, Model model) {
		SessionUserInfo sessinInfo = sessionExtractor.extractSessionUserInfo(session);
		UserInfoDto user = sessionExtractor.extractUserInfoDtoFromSessionInfo(session);

		
		if(error.hasErrors()) {
			model.addAttribute("userName",user.getName());
			model.addAttribute("detail",dto);
			model.addAttribute("error",error);
			
			List<ObjectError> lists = error.getAllErrors();
			for(ObjectError err : lists) {
				System.out.println(err);
			}

			return "/corporate/corporateIntroduction";
		}
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
											.salary(dto.getSalary())
											.build();
																	
		corpRepo.corporateDetailSave(corpDto);
		sessinInfo.setCheck(0);
		user.setCheck_detail(0);
		
		session.setAttribute("userInfo", sessinInfo);
		
		
		
		
		
		return "redirect:/corporate/cpinfo?register=on";
	}
	
		@GetMapping("/update/{cid}") 
		public String getUpdatePageForCorporate(@PathVariable Long cid,Model model, HttpSession session) {
			Optional<CorporateDetailDto> dto = corpRepo.findByIdForCorporate(cid);
			
			
			model.addAttribute("user", dto.get());

			return "corporate/cpUpdate";
		}

		@PostMapping("/update/{cid}")
		@Transactional
		public String updateCorporateDetail(@PathVariable Long cid, @Validated @ModelAttribute CorporateDetailRegisterForm dto, BindingResult error, Model model) {
			
			if(error.hasErrors()) {
				model.addAttribute("error",error);
				return "/corporate/cpUpdate";

			}
			
			CorporateDetailDto update = corpRepo.findByIdForCorporate(cid).get();
			
			
				WelfareDto welfare = new WelfareDto();
				welfare.makeDto(dto.getWlfare());
				
				
				update.setStaff_number(dto.getStaffNumber());
				update.setWelfare(welfare);
				update.setSummary(dto.getSummary());
				update.setSalary(dto.getSalary());
				
				corpRepo.update(update);
			
				
			
			return "redirect:/corporate/cpinfo?edit=on";
		}


}
