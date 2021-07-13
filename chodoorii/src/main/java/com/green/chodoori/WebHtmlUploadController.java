package com.green.chodoori;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class WebHtmlUploadController {

	
	@GetMapping("/hi")
	public String test() {
		System.out.println("호출");
		return "test";
	}

}
