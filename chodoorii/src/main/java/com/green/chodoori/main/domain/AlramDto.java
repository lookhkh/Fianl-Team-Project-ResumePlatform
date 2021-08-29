package com.green.chodoori.main.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import
javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import
javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.green.chodoori.dto.testDto;
import com.green.chodoori.nonCorporate.domain.SharedMyResumeInfoDto;

import lombok.Data;

@Data
@Entity
@Table(name= "alram") 
@SequenceGenerator(name = "alram_seq") 
public class AlramDto {

@Id @GeneratedValue(generator = "alram_seq") 
private Long id;
  

private String towhom;//받는 사람
  
private String fromwhom;//주는 사람
  
@Temporal(TemporalType.DATE)
private Date registerDate;

private String message;
}
 