package com.green.chodoori.corporate.web.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CorporateDetailRegisterForm {

	@NotNull
	@Range(max = 300)
	private Integer staffNumber;
	@NotNull
	private String salary;
	@NotNull
	private List<String> wlfare;
	@NotNull
	@NotBlank
	private String summary;
	


}
