package com.green.chodoori.main.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVo;
import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVoRepo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVoRepo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.service.SignUpService;
import com.green.chodoori.main.web.domain.SignUpFormVO;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;
import com.green.chodoori.util.signup.UserMetaDataSeparatorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/signup")
@CrossOrigin("*") //임시적, jsp로 변경 후, 삭제 예정.
public class SignupController {

	@Autowired
	ImgUploadAndGenerateSignUpDto service;

	@Autowired
	SignUpService signUpService;

	@GetMapping
	public String gettingSignupForm() {
		
		log.info("회원가입 기업/일반회원 선택 폼 호출 요청 수신");
		
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
	public String signupPhaseTwoRequireUserInfo(@RequestParam("sort") Integer sort, @Valid @ModelAttribute SignUpFormVO vo, BindingResult error, Model model) throws IllegalStateException, IOException {
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
		
		UserInfoDto dto = null;
		
		switch(sort) {
			case 0:{
				 dto = service.imgUploadAndGenerateSignUpDto(vo.getFile(), vo);
				 dto.setSort(0);
				log.info("회원가입 정보 : {}",dto.toString());
				model.addAttribute("userId",dto.getId());
				signUpService.signUpProcessor(dto);
				 
				return "/main/signupMetaData";
			}
			case 1:{
				 dto = service.imgUploadAndGenerateSignUpDto(vo.getFile(), vo);
				 dto.setSort(1);
					log.info("회원가입 정보 : {}",dto.toString());
					signUpService.signUpProcessor(dto);
					model.addAttribute("userId",dto.getId());
					
					return "/main/signupForCorporateMetadata";
				 
			}
		}
		return null;
		

		
	}
	
	
	@ResponseBody
	@PostMapping("/users/metadata")
	public void getUserMetadata(@RequestBody MultiValueMap<String,String> map) {

		signUpService.individualMetaDataService(map);
		
	}
	
	
	@Transactional
	@ResponseBody
	@PostMapping("/corporate/metadata")
	public void getCorporateMetadata(@ModelAttribute CorporateSignUpMetaDataFormVo dto) {
		
		
		signUpService.corporateMetaDataService(dto);
		
		
	}
	
	
	
	
	
	
	
	
}
