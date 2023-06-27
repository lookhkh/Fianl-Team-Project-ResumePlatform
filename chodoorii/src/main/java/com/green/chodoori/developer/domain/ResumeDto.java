package com.green.chodoori.developer.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.green.chodoori.developer.web.domain.IntroductionDto;
import com.green.chodoori.developer.web.domain.SkillSetDto;
import com.green.chodoori.developer.web.domain.SnsAddressDto;
import com.green.chodoori.main.domain.UserInfoDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@Table(name = "USER_RESUME")
public class ResumeDto {
	
	
	public ResumeDto() {
		super();
	}
	@Builder
	public ResumeDto(String id, UserInfoDto user, SkillSetDto skill_dto, IntroductionDto intro_dto,
			SnsAddressDto sns_dto, 
			 Integer disclosurestatus,
			 String template_kind, 
			 String portfolio_first_img,
			String portfolio_first_github, 
			 String portfolio_first_name, String portfolio_first_desc,
			String portfolio_second_img, 
			 String portfolio_second_github, String portfolio_second_name,
			String portfolio_second_desc,
			 String portfolio_third_img, String portfolio_third_github,
			String portfolio_third_name,
			 String portfolio_third_desc) {
		super();
		this.id = id;
		this.user = user;
		this.skill_dto = skill_dto;
		this.intro_dto = intro_dto;
		this.sns_dto = sns_dto;
		this.disclosurestatus = disclosurestatus;
		this.template_kind = template_kind;
		this.portfolio_first_img = portfolio_first_img;
		this.portfolio_first_github = portfolio_first_github;
		this.portfolio_first_name = portfolio_first_name;
		this.portfolio_first_desc = portfolio_first_desc;
		this.portfolio_second_img = portfolio_second_img;
		this.portfolio_second_github = portfolio_second_github;
		this.portfolio_second_name = portfolio_second_name;
		this.portfolio_second_desc = portfolio_second_desc;
		this.portfolio_third_img = portfolio_third_img;
		this.portfolio_third_github = portfolio_third_github;
		this.portfolio_third_name = portfolio_third_name;
		this.portfolio_third_desc = portfolio_third_desc;
	}
	
	@Id
	String id;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="RESUME_ID")
	private UserInfoDto user;
	
	@Embedded
	private SkillSetDto skill_dto;
	
	@Embedded
	private IntroductionDto intro_dto;
	
	@Embedded
	private SnsAddressDto sns_dto;
	
	private Integer disclosurestatus;
	
	private String template_kind;
	
	private String portfolio_first_img;
	private String portfolio_first_github;
	private String portfolio_first_name;
	private String portfolio_first_desc;
	
	private String portfolio_second_img;
	private String portfolio_second_github;
	private String portfolio_second_name;
	private String portfolio_second_desc;
	
	private String portfolio_third_img;
	private String portfolio_third_github;
	private String portfolio_third_name;
	private String portfolio_third_desc;

	
	
	
}
