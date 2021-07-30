package com.green.chodoori.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.chodoori.util.mail.MailAuthInfoDto;
import com.green.chodoori.util.mail.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/email")
public class EmailAuthController {
	
	@Autowired
	MailService service;
	
	
	@PostMapping
	public ResponseEntity<String> generateAuthNum(@RequestBody String email, HttpSession session){
		log.info(" 메일 서비스 호출");
		service.mailSend(email, session);

		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/{authNum}")
	public ResponseEntity<String> checkAuthNum(@PathVariable String authNum){
		MailAuthInfoDto dto =service.getStore().get("auth");
		System.out.println(dto.toString());
		
		String storedAuthNum = dto.getAuthInfo();
		
		log.info("저장된 인증번호 : {}",storedAuthNum);
		log.info("입력된 인증번호 : {}",authNum);
		
		
		return storedAuthNum.equals(authNum)?new ResponseEntity<String>(HttpStatus.OK):new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	@GetMapping("/lookupid/{email}")
	public ResponseEntity<String> sendIdtoGivenEmail(@PathVariable String email){
		//email을 통하여 유저 정보 가져오는 로직 작성
		System.out.println("호출됨");
		String tempId = "lookhkh";
		
		try {
		service.sendMailForIdLookUp(email, tempId);
		return ResponseEntity.ok("요청이 완료되었습니다");
		
			}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body("문제가 발생하였습니다");
		}
		
	}
	
	@GetMapping("/lookuppw")
	public ResponseEntity<String> sendPwtoGivenEmail(@RequestParam("email")String email, @RequestParam("id") String id){
		
		//아이디, 이메일로 검증로직 작성
		System.out.println("비번찾기 요청됨");
		String tempPw = "1234";
		
		
		
		try {
			service.sendMailForPasswordLookUp(email,id ,tempPw);
			return ResponseEntity.ok("요청이 성공적으로 접수되었습니다");
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body("요청에 실패하였습니다");

		}
	}
	


}