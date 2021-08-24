package com.green.chodoori.nonCorporate.web.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class SnsAddressDto {

	
	
	public SnsAddressDto() {
		super();
	}
	private String blog_address;
	private String github_address;
	private String facebook_address;
	private String instagram_address;
	
}
