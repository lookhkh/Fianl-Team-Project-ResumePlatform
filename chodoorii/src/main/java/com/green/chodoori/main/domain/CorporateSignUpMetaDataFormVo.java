package com.green.chodoori.main.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="CORPORTAE_USER_METADATA")
public class CorporateSignUpMetaDataFormVo {

	
	
	public CorporateSignUpMetaDataFormVo() {
		super();
	}

	@Id
	private String id;
	
	private String bussinessNum;
	private String address;
	private String managerName;
	private String managerContactNum;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserInfoDto user_info_corp;
	
} 
