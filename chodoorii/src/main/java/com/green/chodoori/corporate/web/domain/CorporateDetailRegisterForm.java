package com.green.chodoori.corporate.web.domain;

import java.util.List;

import lombok.Data;

@Data
public class CorporateDetailRegisterForm {

	private Integer staffNumber;
	private String Salary;
	private List<String> wlfare;
	private String summary;
}
