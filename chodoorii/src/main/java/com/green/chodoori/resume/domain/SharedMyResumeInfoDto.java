package com.green.chodoori.resume.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.green.chodoori.main.domain.UserInfoDto;

import lombok.Data;

@Data
@Entity
@Table(name = "share_resume_info")
@SequenceGenerator(name = "shared_resume_seq")
public class SharedMyResumeInfoDto {

	@Id @GeneratedValue(generator = "shared_resume_seq" )
	Long id;
	
	@OneToOne
	@JoinColumn(name = "resume_id")
	UserInfoDto userInfoDto;
	
	@Temporal(TemporalType.DATE)
	Date registerDate;
	
	
}
