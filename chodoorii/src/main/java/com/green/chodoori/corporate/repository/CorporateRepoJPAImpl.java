package com.green.chodoori.corporate.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.green.chodoori.corporate.domain.CorporateDetailDto;
import com.green.chodoori.corporate.domain.CorporateDetailDtoRepo;
import com.green.chodoori.developer.domain.ResumeDto;
import com.green.chodoori.developer.domain.ResumeDtoRepo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVoRepo;
import com.green.chodoori.main.domain.UserInfoRepo;

@Repository
public class CorporateRepoJPAImpl implements CorporateRepo {

	@Autowired
	ResumeDtoRepo repo;
	
	@Autowired
	UserInfoRepo UserRepo;
	
	@Autowired
	CorporateDetailDtoRepo corpRepo;
	
	@Autowired
	IndividualSginUpMetadataFormVoRepo individualRepo;
	
	public Page<ResumeDto> findByDisclosurestatus(Integer disclosureStatus, Pageable pageable){
		return repo.findByDisclosurestatus(disclosureStatus, pageable);
	}
	
	public Optional<ResumeDto> findById(String id) {
		return repo.findById(id);
	}
	
	public Page<CorporateDetailDto> findAll(Pageable page){
		return corpRepo.findAll(page);
	}
	
	public void corporateDetailSave(CorporateDetailDto dto) {
		corpRepo.save(dto);
		
	}
	
	public Optional<CorporateDetailDto> findByIdForCorporate(Long cid){
		return corpRepo.findById(cid);
	}

	@Override
	public void deleteCorporDetail(String id) {
		CorporateDetailDto dto = corpRepo.findByUserid(id);
		corpRepo.delete(dto);
		
	}
	
	@Override
	public void update(CorporateDetailDto corpDetail) {
		corpRepo.save(corpDetail);

		
	}
	@Override
	public IndividualSginUpMetadataFormVo findUserMetadataById(String userId) {
		
		return individualRepo.findById(userId).get();
	}
}
