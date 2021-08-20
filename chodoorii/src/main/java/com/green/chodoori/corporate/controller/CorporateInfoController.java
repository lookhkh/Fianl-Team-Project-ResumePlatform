package com.green.chodoori.corporate.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.corporate.domain.WelfareDto;
import com.green.chodoori.error.CompanayDetailNotFoundError;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/corporate")
public class CorporateInfoController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;
	
	@Autowired
	CorporateDetailDtoRepo corporateRepo;
	
	@Autowired
	ResumeDtoRepo Repo;
	
	@GetMapping("/cpinfo")
	public String ViewList(@PageableDefault(page = 0,size = 8)Pageable page, Model model,HttpSession session) {
		Page<CorporateDetailDto> pageable = corporateRepo.findAll(page);
		
		model.addAttribute("pageable",pageable);
		
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
	@GetMapping("/detail/{cid}")//cid >> Corporate의 기본키 값으로 찾을 예정
	public String DetailCorporateInfo(@PathVariable Long cid,Model model) {
		Optional<CorporateDetailDto> dto = corporateRepo.findById(cid);
		
		
		if(!dto.isPresent()) {
			throw new CompanayDetailNotFoundError("요청하신 정보가 존재하지 않습니다");
		}
		
		WelfareDto welfare = dto.get().getWelfare();
		List<String> lists = welfare.makeList();
		
		model.addAttribute("welfare",lists);
		model.addAttribute("detail",dto.get());
		return "corporate/detail";
	}
	
	
}
