package com.green.chodoori.developer.web.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class IntroductionDto {
	
	
	
	public IntroductionDto() {
		super();
	}
	private String introduction_main;
	private String introduction_header;
	private String introduction_img_path;
	
}
