package com.green.chodoori.resume.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.IntroductionDto;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;
import com.green.chodoori.resume.domain.SkillSetDto;
import com.green.chodoori.resume.domain.SnsAddressDto;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

@Controller
@RequestMapping("/resume")
public class ResumeRegisterController {
	
	@Autowired
	ImgUploadAndGenerateSignUpDto imgService;
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	@Autowired
	UserInfoRepo userRepo;
	
	@GetMapping("/template")
	public String templateChoicePage() {
		
		return "/resume/resumeChoice";
	}
	
	@GetMapping("/form")
	public String templateFormPage(@RequestParam("template")String template,Model model) {
		model.addAttribute("template",template);
		return "/resume/resumeForm";
	}
	
	@Transactional
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
		


		
		
		ResumeDto resume = new ResumeDto();
		
		SnsAddressDto sns = new SnsAddressDto();
		sns.setBlog_address(blog_address);
		sns.setFacebook_address(facebook_address);
		sns.setGithub_address(github_address);
		sns.setInstagram_address(instagram_address);
		
		resume.setSns_dto(sns);
		
		IntroductionDto intro = new IntroductionDto();
		intro.setIntroduction_header(introduction_header);
		intro.setIntroduction_main(introduction_main);
		
		if(!introduction_img_path.isEmpty()) {
		intro.setIntroduction_img_path(imgService.imgUploadAndGenerateSignUpDto(introduction_img_path));
		}
		
		resume.setIntro_dto(intro);
		

		
		SkillSetDto skill = new SkillSetDto();
		
		if(skil_set.length>=1&&skil_set[0]!=null) {
			skill.setSkill_set_first(skil_set[0]);
		}
		if(skil_set.length>=2&&skil_set[1]!=null) {
			skill.setSkill_set_second(skil_set[1]);
		}
		if(skil_set.length>=3&&skil_set[2]!=null) {
			skill.setSkill_set_third(skil_set[2]);
		}
		if(skil_set.length>=4&&skil_set[3]!=null) {
			skill.setSkill_set_forth(skil_set[3]);
		}
		if(skil_set.length>=5&&skil_set[4]!=null) {
			skill.setSkill_set_fifth(skil_set[4]);
		}
		if(skil_set.length>=6&&skil_set[5]!=null) {
			skill.setSkill_set_sixth(skil_set[5]);
		}
		if(skil_set.length>=7&&skil_set[6]!=null) {
			skill.setSkill_set_seventh(skil_set[6]);
		}
		if(skil_set.length>=8&&skil_set[7]!=null) {
			skill.setSkill_set_eieth(skil_set[7]);
		}
		
		
		resume.setSkill_dto(skill);
		
		

		resume.setTemplate_kind(template_kind);
		
		
		
		resume.setDisclosurestatus(disclosure.equals("on")?0:1);
	
		resume.setPortfolio_first_name(portfolio_first_name);
		resume.setPortfolio_first_github(portfolio_first_github);
		resume.setPortfolio_first_desc(portfolio_first_desc);
		if(!portfolio_first_img.isEmpty()) {
		String imgPathForFirst= imgService.imgUploadAndGenerateSignUpDto(portfolio_first_img);
		resume.setPortfolio_first_img(imgPathForFirst);

		}

		
		resume.setPortfolio_second_desc(portfolio_second_desc);
		resume.setPortfolio_second_github(portfolio_second_github);
		resume.setPortfolio_second_name(portfolio_second_name);
		

		if(!portfolio_second_img.isEmpty()) {
		resume.setPortfolio_second_img(imgService.imgUploadAndGenerateSignUpDto(portfolio_second_img));
		}
		
		resume.setPortfolio_third_desc(portfolio_third_desc);
		resume.setPortfolio_third_github(portfolio_third_github);
		resume.setPortfolio_third_name(portfolio_third_name);
		

		
		if(!portfolio_third_img.isEmpty()) {
		resume.setPortfolio_third_img(imgService.imgUploadAndGenerateSignUpDto(portfolio_third_img));
		}
		
		SessionUserInfo sessionUser = (SessionUserInfo) session.getAttribute("userInfo");
		UserInfoDto user = userRepo.getById(sessionUser.getId());
		user.setCheck_detail(0);
		resume.setUser(user);
		sessionUser.setCheck(0);
		session.setAttribute("userInfo", sessionUser);
		userRepo.save(user);
		resumeRepo.save(resume);
		
		session.setAttribute("temp", resume);
		
		System.out.println(resumeRepo.findById(user.getId()).toString());
		
		model.addAttribute("temp",resume);
		
		String templateName = "/resume/template/templateSample"+template_kind;
		
		System.out.println(templateName);
		
		return templateName;
	}
	

}
