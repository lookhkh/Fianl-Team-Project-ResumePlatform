package com.green.chodoori.resume.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.web.domain.IntroductionDto;
import com.green.chodoori.resume.web.domain.SkillSetDto;
import com.green.chodoori.resume.web.domain.SnsAddressDto;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

@Service
public class ResumeDtoCreator {
	
	@Autowired
	ImgUploadAndGenerateSignUpDto imgService;

	public ResumeDto resumeDtoCreator(String template_kind,
									  String introduction_header,
									  String introduction_main,
									  MultipartFile introduction_img_path,
									  String[] skil_set,
									  String blog_address,
									  String github_address,
									  String instagram_address,
									  String facebook_address,
									  String disclosure,
									  MultipartFile portfolio_first_img,
									  String portfolio_first_name,
									  String portfolio_first_github,
										String portfolio_first_desc,
										MultipartFile portfolio_second_img,
										String portfolio_second_name,
										String portfolio_second_github,
										String portfolio_second_desc,
										MultipartFile portfolio_third_img,
										String portfolio_third_name,
										String portfolio_third_github,
										String portfolio_third_desc) throws IllegalStateException, IOException {
	
	
	
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
	
	return resume;
}
}
