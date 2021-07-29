package com.green.chodoori;

import java.util.Optional;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.chodoori.main.domain.TestDto;
import com.green.chodoori.main.domain.TestRepository;

@SpringBootTest
public class JPAtest {

	@Autowired
	TestRepository repo;
	
	@Test
	@Transactional
	public void jpa_connection_test() {
		TestDto dto = new TestDto();
		dto.setName("hy");
		repo.save(dto);
		
		Optional<TestDto> check = repo.findById(1L);
		Assertions.assertThat(dto).isEqualTo(check.get());
	}
}
