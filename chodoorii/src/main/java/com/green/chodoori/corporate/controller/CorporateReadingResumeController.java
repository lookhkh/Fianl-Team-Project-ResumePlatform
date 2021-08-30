package com.green.chodoori.corporate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.repository.CorporateRepo;
import com.green.chodoori.developer.domain.ResumeDto;
import com.green.chodoori.error.ResumeNotFoundError;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.service.ExtractSessionInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class CorporateReadingResumeController {
	
	@Autowired
	CorporateRepo corpRepo;
	
	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	
	@GetMapping("/lists")
	public String ViewResume(@PageableDefault(page = 0,size = 4)Pageable pageable, Model model) {
		Page<ResumeDto> dto = corpRepo.findByDisclosurestatus(0, pageable);
		List<ResumeDto> resumeLists = dto.getContent();
		List<IndividualSginUpMetadataFormVo> metadatas = new ArrayList<>();
		
		for(int i=0; i<resumeLists.size(); i++) {
			IndividualSginUpMetadataFormVo temp = corpRepo.findUserMetadataById(resumeLists.get(i).getId());
			metadatas.add(temp);
		}

		model.addAttribute("dto",dto);
		model.addAttribute("metadatas",metadatas);
		return "corporate/resume";
	}
	
	
	@GetMapping("/display/{id}")
	public String selectresume(@PathVariable String id,Model model,HttpSession session) {
		Optional<ResumeDto> dto = corpRepo.findById(id);
		UserInfoDto user = dto.get().getUser();
		
		if(!dto.isPresent()) {
			throw new ResumeNotFoundError("요청하신 이력서정보가 존재하지 않습니다");
		}
		String templateNumber = dto.get().getTemplate_kind();
		String template = "/resume/template/templateSample" + templateNumber;

	
		model.addAttribute("user",user);
		model.addAttribute("resume",dto.get());
		return template;
	}
}	

