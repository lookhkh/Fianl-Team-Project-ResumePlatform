package com.green.chodoori.main.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVo;
import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVoRepo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVoRepo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

@Repository
public class MainRepositoryJPAImpl implements MainRepository  {
	
	@Autowired
	UserInfoRepo userRepo;
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	@Autowired
	IndividualSginUpMetadataFormVoRepo individualMetaRepo;
	
	@Autowired
	CorporateSignUpMetaDataFormVoRepo corporateMetaRepo;
	
	@Autowired
	IndividualSginUpMetadataFormVoRepo individualRepo;
	
	@Autowired
	CorporateSignUpMetaDataFormVoRepo corpRepo;
	
	
	public Optional<UserInfoDto> findById(String id) {
		Optional<UserInfoDto> dto = userRepo.findById(id);
		return dto;
	}
	
	public Optional<UserInfoDto> findByEmail(String email) {
		Optional<UserInfoDto> dto = Optional.of(userRepo.findByEmail(email));
		return dto;
	} 
	
	public void saveCorporateMetaData(CorporateSignUpMetaDataFormVo dto) {
		corpRepo.save(dto);
	}
	
	public void saveIndividualMetaData(IndividualSginUpMetadataFormVo dto) {
		individualRepo.save(dto);
	}
	
	public void saveUserInfo(UserInfoDto dto) {
		userRepo.save(dto);
	}

	@Override
	public UserInfoDto getById(String id) {

		return userRepo.getById(id);
	}
}
