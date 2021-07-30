package com.green.chodoori;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class WebHtmlUploadController {

	
	@GetMapping
	public String test(@RequestParam(name = "name",required = false,defaultValue = "Stranger")String name, Model model) {
		 
		model.addAttribute("name",name);
		List<String> list = new ArrayList<>();
		list.add("hi");
		list.add("firend");
		model.addAttribute("list",list);
		 
		 log.info("요청  : 인덱스 페이지 호출");

		return "index";
	}

}
