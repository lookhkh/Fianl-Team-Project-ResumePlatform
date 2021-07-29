package com.green.chodoori.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TestDto {

	@Id @GeneratedValue
	@Column(name="TEST_ID")
	private Long id;
	
	@Column(name="TEST_NAME")
	private String name;

	public TestDto() {
		super();
	}
	
	
	
}
