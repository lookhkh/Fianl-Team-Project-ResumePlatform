package com.green.chodoori.main.web.domain;

import com.green.chodoori.error.PasswordNotEqualWithConfirmedPwError;
import com.green.chodoori.error.RequestedUserNotFound;
import com.green.chodoori.main.domain.UserInfoDto;

import lombok.Data;

@Data
public class LoginForm {

	//회원 정보를 가지고 도메인 객체에서 바로 검증?
	
	private String id;
	private String pw;
	
	
	
}
