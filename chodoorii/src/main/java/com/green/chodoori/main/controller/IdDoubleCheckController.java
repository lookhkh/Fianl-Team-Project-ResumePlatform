package com.green.chodoori.main.controller;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.repository.MainRepository;

@Controller
@RequestMapping("/idcheck")
@CrossOrigin("*")
public class IdDoubleCheckController {

	//추후 디비 테이블 제작 후에는, 연동할 예정
	
	@Autowired
	UserInfoRepo repo;
	
	@Autowired
	MainRepository mainRepo;
	
	private static final String idRegExp = "^[0-9a-z]+$";
	
	private Pattern idpattern;		//아이디 패턴 변수
	
	public IdDoubleCheckController() {
		idpattern = Pattern.compile(idRegExp);			//아이디 유효성 검사를 변수에 저장 
	}
	
	@ResponseBody
	@GetMapping
	public ResponseEntity<String> idCheck(@RequestParam String id){
		System.out.println("요청 아이디 정보 : "+id);
		
		Optional<UserInfoDto> dto = mainRepo.findById(id);
		
		if(id.length()<5) {
			return ResponseEntity.badRequest().body("아이디는 5글자 이상");
		}
		
		if(dto.isPresent()) {
		return ResponseEntity.badRequest().body("이미 존재하는 아이디입니다");
		}
		
		Matcher matcher = idpattern.matcher(id);
		
		if(!matcher.matches()) {
			return ResponseEntity.badRequest().body("아이디는 영문,숫자로만 구성할수있습니다.");
		}
		return ResponseEntity.ok("사용 가능한 아이디입니다");
}
}
