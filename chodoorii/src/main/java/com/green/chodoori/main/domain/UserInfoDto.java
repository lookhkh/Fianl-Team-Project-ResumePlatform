package com.green.chodoori.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="USER_INFO")
public class UserInfoDto {
	
	public UserInfoDto() {
		this.check_detail=1;
	}
	
	@Id @Column(name = "USER_ID")
	private String id;
	private String name;
	@Column(name = "PROFILE_PATH")
	private String imgPath;
	@Column(name = "PW")
	private String pw;
	@Column(name = "EMAIL")
	private String email;
	@Column(name="CITY")
	private String city;
	@Column(name="BIRTH")
	private String birth;
	@Column(name="FLAG")
	private Integer sort;
	private String contact_num;
	
	@Column(name="check_")
	private Integer check_detail;

	
	


}
