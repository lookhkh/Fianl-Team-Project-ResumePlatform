package com.green.chodoori.main.controller;

import java.io.IOException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			
			return "errors";
		}
		
		UserInfoDto dto = null;
		
		switch(sort) {
			case 0:{
				 dto = service.imgUploadAndGenerateSignUpDto(vo.getFile(), vo);
				 dto.setSort(0);
				log.info("회원가입 정보 : {}",dto.toString());
				model.addAttribute("info",dto);
				 
				return "test";
			}
			case 1:{
				 dto = service.imgUploadAndGenerateSignUpDto(vo.getFile(), vo);
				 dto.setSort(1);
					log.info("회원가입 정보 : {}",dto.toString());
					
					model.addAttribute("info",dto);
					
					return "test_corporate";
				 
			}
		}
		
		
		
		
		log.info("회원가입 정보 : {}",dto.toString());
		
		model.addAttribute("info",dto);
		
		return "test";
		
	}
	
	@ResponseBody
	@PostMapping("/users/metadata")
	public void test(@RequestBody MultiValueMap<String,String> map) {
		System.out.println(map);
		
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		System.out.println(map.get("position"));


	}
	
	
	
	
	
	
}
