package com.green.chodoori.main.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionUserInfo {
	
	private String id;
	private String imgPath;
	private Integer sort;
	private Integer check;
}
