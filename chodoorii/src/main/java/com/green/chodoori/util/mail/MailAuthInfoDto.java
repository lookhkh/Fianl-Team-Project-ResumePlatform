package com.green.chodoori.util.mail;

import java.util.Date;

import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailAuthInfoDto {
	
	private Long generatedTime;
	
	@javax.validation.constraints.Email
	private String authInfo;

	public MailAuthInfoDto(@Email String authInfo) {
		Date date = new Date();
		
		this.generatedTime = date.getTime();
		this.authInfo = authInfo;
	}

	

}
