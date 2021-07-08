package com.green.chodoori;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/upload")
public class WebHtmlUploadController {

	@Autowired
	Repo repo;
	
	@PostMapping
	public String test(@RequestBody byte[] html) {
System.out.println("");
		System.out.println(html);
		System.out.println(html.toString().length());
		repo.repo.put("1", html);
		System.out.println(html.length);
		System.out.println(html);
		


		
		
		return "ok";
		
	}
	
	@GetMapping
	public byte[] getTest(HttpServletResponse res) {
		res.setHeader("Content-type", "application/octet-stream");
		System.out.println("getmapping ȣ��");
		return repo.repo.get("1");
	}
	
}
