package com.green.chodoori.main.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlramDtoRepo extends JpaRepository<AlramDto, Long> {

	@Query(value="select * from alram where towhom= ? order by register_date desc ",nativeQuery=true)
	List<AlramDto> findByTowhom(String userId);
}
