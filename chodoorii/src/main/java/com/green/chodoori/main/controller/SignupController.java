package com.green.chodoori.main.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.service.SessionCreateService;
import com.green.chodoori.main.service.SignUpService;
import com.green.chodoori.main.web.domain.SignUpFormVO;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/signup")
@CrossOrigin("*") //임시적, jsp로 변경 후, 삭제 예정.
public class SignupController {

	@Autowired
	SessionCreateService sessionService;
	
	@Autowired
	ImgUploadAndGenerateSignUpDto service;

	@Autowired
	SignUpService signUpService;

	@GetMapping
	public String gettingSignupForm() {
		
		log.info("회원가입 기업/일반회원 선택 폼 호출 요청 수신");
		log.info("내용 {}","hi");
		return "/main/signupSort";
	}
	
	@GetMapping("/{sort}")
	public String gettingSignupRequiredForm(@PathVariable String sort) {
		log.info("회원가입 {} 선택 폼 호출 요청 수신 ",sort);
		
		if(sort.equals("corporate")) {
			return "/main/signupForCorporateRequired";
		}else {
			return "/main/signupRequired";
		}

	}
	
	
	
	@PostMapping
	public String signupPhaseTwoRequireUserInfo(HttpServletRequest req ,@RequestParam("sort") Integer sort, @Valid @ModelAttribute SignUpFormVO vo, BindingResult error, Model model) throws IllegalStateException, IOException {
		log.info("받은 인수 : {},{}",vo.getFile().getOriginalFilename(), vo.toString());
		log.info("가입 유형  : {}",(sort==0?"일반회원":"기업회원"));


		
		if(!vo.checkPwWithConfirmPw()) {
			error.addError(new ObjectError("pwError","비밀번호가 일치하지 않습니다"));
		}
		
		if(!vo.checkExtensionOfImg()) {
			error.addError(new ObjectError("fileExtError", "지원하지 않는 형식입니다"));
		}
				
		if(error.hasErrors()) {
			error.getAllErrors().forEach(a->{
				log.info("에러 내용 : {}",a);
			});
			
			return "index";
		}

		UserInfoDto dto = new UserInfoDto();
		
		switch(sort) {
			case 0:{
				 String imgPath =  service.imgUploadAndGenerateSignUpDto(vo.getFile());
				
				 dto.setBirth(vo.getBirth());
				 dto.setCity(vo.getCity());
				 dto.setContact_num(vo.getContact_num());
				 dto.setEmail(vo.getEmail());
				 dto.setName(vo.getName());
				 dto.setPw(vo.getPw());
				 dto.setImgPath(imgPath);
				 dto.setId(vo.getId());
				
				 
				 
				 dto.setSort(0);
				log.info("회원가입 정보 : {}",dto.toString());
				model.addAttribute("userId",dto.getId());
				signUpService.signUpProcessor(dto);
				sessionService.sessionCreate(vo.getId(), req);
				
				 
				return "/main/signupMetaData";
			}
			case 1:{
				 String imgPath =  service.imgUploadAndGenerateSignUpDto(vo.getFile());
				 
				 dto.setContact_num(vo.getContact_num());
				 dto.setEmail(vo.getEmail());
				 dto.setName(vo.getName());
				 dto.setPw(vo.getPw());
				 dto.setImgPath(imgPath);
				 dto.setId(vo.getId());
				 
				
				 
				 
				 	dto.setSort(1);
					log.info("회원가입 정보 : {}",dto.toString());
					signUpService.signUpProcessor(dto);
					model.addAttribute("userId",dto.getId());
					sessionService.sessionCreate(vo.getId(), req);

					
					return "/main/signupForCorporateMetadata";
				 
			}
		}
		return null;
		

		
	}
	
	
	
	@PostMapping("/users/metadata")
	public String getUserMetadata(@RequestBody MultiValueMap<String,String> map) {

		signUpService.individualMetaDataService(map);
		return "redirect:/";
		
	}
	
	
	@Transactional
	@PostMapping("/corporate/metadata")
	public String getCorporateMetadata(@ModelAttribute CorporateSignUpMetaDataFormVo dto) {
		
		
		signUpService.corporateMetaDataService(dto);
		return "redirect:/";

		
	}
	
	
	
	
	
	
	
	
}
