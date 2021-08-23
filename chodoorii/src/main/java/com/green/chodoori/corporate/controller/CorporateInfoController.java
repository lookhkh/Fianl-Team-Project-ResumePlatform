package com.green.chodoori.corporate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.corporate.domain.WelfareDto;
import com.green.chodoori.corporate.repository.CorporateRepo;
import com.green.chodoori.error.CompanayDetailNotFoundError;
import com.green.chodoori.main.service.ExtractSessionInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/corporate")
public class CorporateInfoController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;

	@Autowired
	CorporateRepo corpRepo;
	
	@Autowired
	CorporateDetailDtoRepo Repo;

	@GetMapping("/cpinfo")
	public String ViewList(@PageableDefault(page = 0, size = 8) Pageable page, Model model) {
		Page<CorporateDetailDto> pageable = corpRepo.findAll(page);

		model.addAttribute("pageable", pageable);

		return "corporate/cpinfo";
	}

	@PostMapping("/cpinfo")
	public String ViewCorporate(CorporateDetailDto dto) {

		log.info("기업홍보관 페이지 요청 수신");
		corpRepo.corporateDetailSave(dto);
		return "corporate/cpinfo";
	}

	// 회사소개 상세보기
	@GetMapping("/detail/{cid}") // cid >> Corporate의 기본키 값으로 찾을 예정
	public String DetailCorporateInfo(@PathVariable Long cid, Model model) {
		Optional<CorporateDetailDto> dto = corpRepo.findByIdForCorporate(cid);

		if (!dto.isPresent()) {
			throw new CompanayDetailNotFoundError("요청하신 정보가 존재하지 않습니다");
		}

		WelfareDto welfare = dto.get().getWelfare();
		List<String> lists = welfare.makeList();

		model.addAttribute("welfare", lists);
		model.addAttribute("detail", dto.get());
		return "corporate/detail";
	}

	// 회사 소개 수정하는 페이지불러오기
	@GetMapping("/update/{cid}") // cid >> Corporate의 기본키 값으로 찾을 예정
	public String updatePage(@PathVariable Long cid,Model model) {
		Optional<CorporateDetailDto> dto = Repo.findById(cid);
		
		model.addAttribute("user", dto.get());
//	public String update(HttpSession session, Model model) {
//		SessionUserInfo user = sessionExtractor.extractSessionUserInfo(session);
//		String userId = user.getId();
//
//		String userName = sessionExtractor.extractUserNameFromSessionInfo(session);
//
//		model.addAttribute("userName", userName);
//
//		return "corporate/cpUpdate";
		return "corporate/cpUpdate";
	}

	// 회사 소개 수정하기
	@PostMapping("/update/{cid}")
	public String changeInfo(@PathVariable Long cid,@RequestBody CorporateDetailDto dto) {
		
		Optional<CorporateDetailDto> update = Repo.findById(cid);
		
		update.ifPresent(user->{
//			user.setUserid(dto.getUserid());
//			user.setCompanayName(dto.getCompanayName());
//			user.setLogo_img(dto.getLogo_img());
			user.setSummary(dto.getSummary());
			user.setStaff_number(dto.getStaff_number());
			user.setWelfare(dto.getWelfare());
			
		});
		
		return "corporate/cpinfo";
	}
}
