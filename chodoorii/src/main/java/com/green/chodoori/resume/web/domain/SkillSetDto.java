package com.green.chodoori.resume.web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class SkillSetDto {

	
	
	public SkillSetDto() {}
	
	private String skill_set_first;
	private String skill_set_second;
	private String skill_set_third;
	private String skill_set_forth;
	private String skill_set_fifth;
	private String skill_set_sixth;
	private String skill_set_seventh;
	private String skill_set_eieth;
	
	@Transient
	private List<String> skills;
	
	
	public void makeSkillSetList() {
		
		skills = new ArrayList<>();
		
		if(StringUtils.hasLength(skill_set_first)) {
			skills.add(skill_set_first);
		}
		
		if(StringUtils.hasLength(skill_set_second)) {
			skills.add(skill_set_second);
		}
		
		if(StringUtils.hasLength(skill_set_third)) {
			skills.add(skill_set_third);
		}
		
		if(StringUtils.hasLength(skill_set_forth)) {
			skills.add(skill_set_forth);
		}
		
		if(StringUtils.hasLength(skill_set_fifth)) {
			skills.add(skill_set_fifth);
		}
		
		if(StringUtils.hasLength(skill_set_sixth)) {
			skills.add(skill_set_sixth);
		}
		
		if(StringUtils.hasLength(skill_set_seventh)) {
			skills.add(skill_set_seventh);
		}
		
		if(StringUtils.hasLength(skill_set_eieth)) {
			skills.add(skill_set_eieth);
		}
	}

	
}
