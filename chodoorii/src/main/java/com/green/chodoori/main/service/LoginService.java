package com.green.chodoori.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.chodoori.error.PasswordIsNotSameError;
import com.green.chodoori.error.RequestedUserNotFound;
import com.green.chodoori.main.domain.AlramDto;
import com.green.chodoori.main.domain.AlramDtoRepo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.repository.MainRepository;
import com.green.chodoori.main.web.domain.LoginForm;
import com.green.chodoori.main.web.domain.SessionUserInfo;

@Service
public class LoginService {

	@Autowired
	MainRepository mainRepo;

	
	@Autowired
	UserInfoRepo repo;
	
	@Autowired
	AlramDtoRepo Alramrepo;
	public boolean userInfoMationCheck(LoginForm form) {
		Optional<UserInfoDto> check = mainRepo.findById(form.getId());
		
		if(!check.isPresent()) {
			throw new RequestedUserNotFound("요청하신 유저 정보가 존재하지 않습니다");
		}
		
		UserInfoDto dto = check.get();
		
		if(dto.getPw().equals(form.getPw())) {
			return true;
		}
		else {
			throw new PasswordIsNotSameError("비밀번호를 다시 확인해주세요"); 
		}
	}
	
	public SessionUserInfo createSessionUserInfoDto(String userId) {
		UserInfoDto dto = mainRepo.findById(userId).get();
		
		return new SessionUserInfo(userId,dto.getImgPath(),dto.getSort(),dto.getCheck_detail());
	}
}
