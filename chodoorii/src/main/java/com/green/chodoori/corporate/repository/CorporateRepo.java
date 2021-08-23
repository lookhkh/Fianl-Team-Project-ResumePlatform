package com.green.chodoori.corporate.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;


public interface CorporateRepo {

	
	
	public Page<ResumeDto> findByDisclosurestatus(Integer disclosureStatus, Pageable pageable);
	
	public Optional<ResumeDto> findById(String id);
	public Page<CorporateDetailDto> findAll(Pageable page);
	
	public void corporateDetailSave(CorporateDetailDto dto);
	
	public Optional<CorporateDetailDto> findByIdForCorporate(Long cid);
	
	public void deleteCorporDetail(String id);

	public void update(CorporateDetailDto corpDetail);
}
