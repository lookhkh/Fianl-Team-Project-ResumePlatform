package com.green.chodoori.developer.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.chodoori.developer.domain.ResumeDto;
import com.green.chodoori.developer.repository.ResumeRepository;
import com.green.chodoori.developer.service.ChangeUsersResumeStatusService;
import com.green.chodoori.developer.service.ResumeDtoCreator;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.repository.MainRepository;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

@Controller
@RequestMapping("/resume")
public class ResumeRegisterController {
	
	@Autowired
	ImgUploadAndGenerateSignUpDto imgService;
	
	@Autowired
	ResumeDtoCreator resumeCreator;
	
	
	@Autowired
	ResumeRepository resumeRepo;
	
	@Autowired
	MainRepository mainRepo;
	
	@Autowired
	ChangeUsersResumeStatusService userStatusService;
	
	
	@GetMapping("/template")
	public String templateChoicePage() {
		
		return "/resume/resumeChoice";
	}
	
	
	
	@GetMapping("/form")
	public String templateFormPage(@RequestParam("template")String template,Model model) {
		model.addAttribute("template",template);
		return "/resume/resumeForm";
	}
	
	@PostMapping("/form")
	public String templageFormInputCheck(HttpSession session,
										@RequestParam(required = false) String template_kind, 
										@RequestParam(required = false) String introduction_header,
										@RequestParam(required = false) String introduction_main,
										@RequestParam(required = false) MultipartFile introduction_img_path,
										@RequestParam(required = false) String[] skil_set,									
										@RequestParam(required = false) String blog_address,
										@RequestParam(required = false) String github_address,
										@RequestParam(required = false) String instagram_address,
										@RequestParam(required = false) String facebook_address,
										@RequestParam(required = false, defaultValue = "off") String disclosure,
										@RequestParam(required = false) MultipartFile portfolio_first_img,
										@RequestParam(required = false) String portfolio_first_name,
										@RequestParam(required = false) String portfolio_first_github,
										@RequestParam(required = false) String portfolio_first_desc,
										@RequestParam(required = false) MultipartFile portfolio_second_img,
										@RequestParam(required = false) String portfolio_second_name,
										@RequestParam(required = false) String portfolio_second_github,
										@RequestParam(required = false) String portfolio_second_desc,
										@RequestParam(required = false) MultipartFile portfolio_third_img,
										@RequestParam(required = false) String portfolio_third_name,
										@RequestParam(required = false) String portfolio_third_github,
										@RequestParam(required = false) String portfolio_third_desc,
										Model model) throws IllegalStateException, IOException {
		
		
	

		ResumeDto resume = resumeCreator.resumeDtoCreator(template_kind, introduction_header, introduction_main, 
														introduction_img_path, skil_set, blog_address, 
														github_address, instagram_address, facebook_address, 
														disclosure, portfolio_first_img, portfolio_first_name, 
														portfolio_first_github, portfolio_first_desc, portfolio_second_img, 
														portfolio_second_name, portfolio_second_github, portfolio_second_desc, 
														portfolio_third_img, portfolio_third_name, portfolio_third_github, 
														portfolio_third_desc);
										
		resume.getSkill_dto().makeSkillSetList();
		
		
		
		SessionUserInfo sessionUser = (SessionUserInfo) session.getAttribute("userInfo");
		UserInfoDto user = mainRepo.findById(sessionUser.getId()).get();
		

		session.setAttribute("temp", resume);
		
	
		model.addAttribute("resume",resume);
		model.addAttribute("preview","on");
		
		String templateName = "/resume/template/templateSample"+template_kind;
				
		return templateName;
	}
	
	@GetMapping("/form/confirm")
	public String confirmResume(HttpSession session, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("director","register");
		
		userStatusService.changeStatus(0, session);
	
		return "redirect:/resume";
	}
	
	
	

}
