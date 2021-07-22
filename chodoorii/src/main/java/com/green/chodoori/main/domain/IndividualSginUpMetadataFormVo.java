package com.green.chodoori.main.domain;

import lombok.Data;

@Data
public class IndividualSginUpMetadataFormVo {

	private String id;
	
	private String position_1;
	private String position_2;
	private String position_3;
	private String position_4;
	private String positions_5;

	private String language_1;
	private String language_2;
	private String language_3;

	private String framework_1;
	private String framework_2;
	private String framework_3;
	
	private String db_1;
	private String db_2;
	private String db_3;

	private Integer exp; //0 신입, 1 경력
	private String period;
	
}
