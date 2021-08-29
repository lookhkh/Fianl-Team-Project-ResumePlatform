package com.green.chodoori.corporate.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.corporate.repository.CorporateRepo;
import com.green.chodoori.corporate.web.domain.WelfareDto;
import com.green.chodoori.error.CompanayDetailNotFoundError;
import com.green.chodoori.main.domain.AlramDto;
import com.green.chodoori.main.domain.AlramDtoRepo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.repository.MainRepository;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;

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
	
	@Autowired
	MainRepository mainRepo;
	
	@GetMapping("/cpinfo") //조회
	public String ViewList(@PageableDefault(page = 0, size = 8) Pageable page, Model model) {
		Page<CorporateDetailDto> pageable = corpRepo.findAll(page);

		model.addAttribute("pageable", pageable);

		return "corporate/cpinfo";
	}

	@PostMapping("/cpinfo")	//저장
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

	
}
