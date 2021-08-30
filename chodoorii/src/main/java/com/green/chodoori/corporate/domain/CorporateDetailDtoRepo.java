package com.green.chodoori.corporate.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CorporateDetailDtoRepo extends JpaRepository<CorporateDetailDto, Long>{

	@Query("SELECT o from CorporateDetailDto o join o.userid u where u.id=:userId")
	CorporateDetailDto findByUserid(String userId);

	
	Page<CorporateDetailDto> findAll(Pageable page);
	
}
