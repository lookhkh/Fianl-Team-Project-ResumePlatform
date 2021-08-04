package com.green.chodoori.main.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="USER_METADATA")
public class IndividualSginUpMetadataFormVo implements Serializable {

	
	
	public IndividualSginUpMetadataFormVo() {
		super();
	}
	@Id 
	private String id;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserInfoDto user_info_ind;
	
	@Transient
	private List<String> position = new ArrayList<>();
	
	
	private String position_1;
	private String position_2;
	private String position_3;
	private String position_4;
	private String position_5;
	
	@Transient
	private List<String> language = new ArrayList<>();
	
	private String lan_1;
	private String lan_2;
	private String lan_3;
	
	
	@Transient
	private List<String> framework = new ArrayList<>();

	private String framework_1;
	private String framework_2;
	private String framework_3;

	
	@Transient
	private List<String> db = new ArrayList<>();

	private String dbs_1;
	private String dbs_2;
	private String dbs_3;

	
	private String exp; //0 신입, 1 경력
	private String period;
	
}
