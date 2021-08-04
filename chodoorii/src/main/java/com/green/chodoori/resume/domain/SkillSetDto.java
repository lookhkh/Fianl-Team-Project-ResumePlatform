package com.green.chodoori.resume.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class SkillSetDto {

	
	
	public SkillSetDto() {
		super();
	}
	private String skill_set_first;
	private String skill_set_second;
	private String skill_set_third;
	private String skill_set_forth;
	private String skill_set_fifth;
	private String skill_set_sixth;
	private String skill_set_seventh;
	private String skill_set_eieth;

	
}
