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

public interface MainRepository {

	
	
	public Optional<UserInfoDto> findById(String id);
	
	public Optional<UserInfoDto> findByEmail(String email);
	

	public void saveCorporateMetaData(CorporateSignUpMetaDataFormVo dto);
	
	public void saveIndividualMetaData(IndividualSginUpMetadataFormVo dto);
	
	public void saveUserInfo(UserInfoDto dto);

	public UserInfoDto getById(String id);
	


}
