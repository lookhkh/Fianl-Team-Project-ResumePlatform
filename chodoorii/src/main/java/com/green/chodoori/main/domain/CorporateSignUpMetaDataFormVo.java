package com.green.chodoori.main.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CorporateSignUpMetaDataFormVo {

	@NotNull @NotEmpty
	private String bussinessNum;
	@NotNull @NotEmpty
	private String address;
	@NotNull @NotEmpty
	private String managerName;
	private String managerContactNum;
	
} 
