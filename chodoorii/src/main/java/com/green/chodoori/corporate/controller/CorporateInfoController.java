package com.green.chodoori.corporate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.main.service.ExtractSessionInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/corporate")
public class CorporateInfoController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@Autowired
	CorporateDetailDtoRepo corporateRepo;
	

	@GetMapping("/cpinfo")
	public String ViewList() {
//		Optional<CorporateDetailDto> dto = corporateRepo.findAll();
		log.info("기업홍보관 페이지 요청 수신");
		return "corporate/cpinfo";
	}
	
	@PostMapping("/cpinfo")
	public String ViewCorporate(CorporateDetailDto dto) {
		log.info("기업홍보관 페이지 요청 수신");
		corporateRepo.save(dto);
		return "corporate/cpinfo";
	}
	
	
	
	
	
	
	
	
	
	//회사소개 상세보기
	@GetMapping("/{cid}")//cid >> Corporate의 기본키 값으로 찾을 예정
	public String DetailCorporateInfo(@PathVariable Long cid,Model model) {
		Optional<CorporateDetailDto> dto = corporateRepo.findById(cid);
		model.addAttribute("cid",cid);
		return "corporate/detail";
	}
	
	
}
