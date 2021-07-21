package com.green.chodoori.main.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SignUpFormVO {

	@Nullable
	private MultipartFile file;
	
	@NotNull @NotEmpty
	private String id;
	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty @Min(value = 3)
	private String pw;
	@NotNull @NotEmpty @Min(value = 3)
	private String confirmedPw;
	
	@Email
	private String email;
	
	private String contactInfo;

	
	
	
	public boolean checkPwWithConfirmPw() {
		if(!this.pw.equals(this.confirmedPw)) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkExtensionOfImg() {
		String ext = this.file.getContentType();
		if(!ext.startsWith("image")) {
			return false;
		}
		return true;
	}

	
	
}
