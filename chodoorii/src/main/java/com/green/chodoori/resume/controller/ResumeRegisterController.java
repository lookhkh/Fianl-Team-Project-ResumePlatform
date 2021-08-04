package com.green.chodoori.resume.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.resume.domain.SnsAddressDto;

@Controller
@RequestMapping("/resume")
public class ResumeRegisterController {
	
	@GetMapping("/template")
	public String templateChoicePage() {
		
		return "/resume/resumeChoice";
	}
	
	@GetMapping("/form")
	public String templateFormPage() {
		return "/resume/resumeForm";
	}
	
	@ResponseBody
	@PostMapping("/form")
	public String templageFormInputCheck(HttpSession session,
										@RequestParam String template_kind, 
										@RequestParam String introduction_header,
										@RequestParam String introduction_main,
										@RequestParam MultipartFile introduction_img_path,
										@RequestParam String[] skil_set,									
										@ModelAttribute SnsAddressDto sns,
										@RequestParam String disclosure,
										@RequestParam MultipartFile portfolio_first_img,
										@RequestParam String portfolio_first_name,
										@RequestParam String portfolio_first_github,
										@RequestParam String portfolio_first_desc,
										@RequestParam MultipartFile portfolio_second_img,
										@RequestParam String portfolio_second_name,
										@RequestParam String portfolio_second_github,
										@RequestParam String portfolio_second_desc,
										@RequestParam MultipartFile portfolio_third_img,
										@RequestParam String portfolio_third_name,
										@RequestParam String portfolio_third_github,
										@RequestParam String portfolio_third_desc) {
		
		
		System.out.println(template_kind+"  "+introduction_header+"  "+introduction_main);
		System.out.println(introduction_img_path);
		System.out.println(sns.toString());
		System.out.println(disclosure);

		for(int i=0; i<skil_set.length; i++) {
			System.out.println(skil_set[i]);
		}
		
		System.out.println(portfolio_first_img);
		System.out.println(portfolio_first_name);
		System.out.println(portfolio_first_github);
		System.out.println(portfolio_first_desc);
		System.out.println(portfolio_second_img);
		System.out.println(portfolio_second_name);
		System.out.println(portfolio_second_github);
		System.out.println(portfolio_second_desc);
		System.out.println(portfolio_third_img);
		System.out.println(portfolio_third_name);
		System.out.println(portfolio_third_github);
		System.out.println(portfolio_third_desc);

		
		
		return "hi";
	}
	

}
