package com.green.chodoori.main.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.main.domain.SignUpFormVO;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/signup")
@CrossOrigin("*") //임시적, jsp로 변경 후, 삭제 예정.
public class SignupController {

	@Autowired
	ImgUploadAndGenerateSignUpDto service;
	
	@PostMapping
	public String signupPhaseTwoRequireUserInfo(@Valid @ModelAttribute SignUpFormVO vo, BindingResult error, Model model) throws IllegalStateException, IOException {
		log.info("받은 인수 : {},{}",vo.getFile().getOriginalFilename(), vo.toString());

		
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
			
			return "errors";
		}

		
		UserInfoDto dto = service.imgUploadAndGenerateSignUpDto(vo.getFile(), vo);
		
		
		
		log.info("회원가입 정보 : {}",dto.toString());
		
		model.addAttribute("info",dto);
		
		return "test";
		
	}
	
	
}
