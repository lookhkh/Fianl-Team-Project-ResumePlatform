package com.green.chodoori.main.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class IndividualSginUpMetadataFormVo {

	private String id;
	
	private List<String> position = new ArrayList<>();
	
	private List<String> language = new ArrayList<>();


	private List<String> framework = new ArrayList<>();

	
	private List<String> db = new ArrayList<>();


	private String exp; //0 신입, 1 경력
	private String period;
	
}
