package com.green.chodoori;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.chodoori.repository.mapper.SampleMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DbConnectionTest {

	@Autowired
	DataSource data;

	@Autowired
	DefaultListableBeanFactory bf;

	@Autowired
	SampleMapper mapper;
	
	
	@Test
	public void connectionTest() {
		
		log.info("데이타 소스 정보 : {}",data);
		
		for(String name : bf.getBeanDefinitionNames()) {
			
			if(!(bf.getBean(name).getClass().getName()).startsWith("org")) log.info("정보 : {}",bf.getBean(name).getClass().getName());

		}
		
		log.info(mapper.getTime());
		
	}
	
	
}
