package com.green.chodoori.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/idcheck")
@CrossOrigin("*")
public class IdDoubleCheckController {

	//추후 디비 테이블 제작 후에는, 연동할 예정
	
	@ResponseBody
	@GetMapping
	public ResponseEntity<String> idCheck(@RequestParam String id){
		System.out.println(id);
		
		if(id.length()<5) {
			return ResponseEntity.badRequest().body("아이디는 5글자 이상");
		}
		return ResponseEntity.ok("ok");
	}
}
