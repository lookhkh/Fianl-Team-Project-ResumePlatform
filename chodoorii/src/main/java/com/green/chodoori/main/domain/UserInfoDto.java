package com.green.chodoori.main.domain;

import lombok.Data;

@Data
public class UserInfoDto {

	private Integer sort;
	private String id;
	private String name;
	private String imgPath;
	private String pw;
	private String email;
	
}
