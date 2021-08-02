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
	
	public boolean isPwEqualWithCheckPw() {
		
	UserInfoDto dto = new UserInfoDto();
	dto.setId("lookhkh");
	dto.setPw("1234");
		
		if(dto.getId().equals(this.id)) {
			if(dto.getPw().equals(this.pw)) {
				return true;
			}else {
				throw new PasswordNotEqualWithConfirmedPwError("비밀번호가 다릅니다");
			}
		}else {
			throw new RequestedUserNotFound("요청하신 아이디 "+ this.id+"는 존재하지 않습니다");
		}
	}
	
}
