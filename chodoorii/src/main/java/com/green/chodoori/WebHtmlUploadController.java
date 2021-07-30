package com.green.chodoori;

import java.text.DateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class WebHtmlUploadController {

	
	@GetMapping
	public String test(HttpServletRequest req) {
		 
		 String client_id = req.getRemoteAddr();
		 
		 
		 log.info("요청  : 인덱스 페이지 호출");

		return "index";
	}

}
