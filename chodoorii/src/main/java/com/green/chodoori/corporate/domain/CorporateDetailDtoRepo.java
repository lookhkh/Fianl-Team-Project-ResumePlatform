package com.green.chodoori.corporate.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CorporateDetailDtoRepo extends JpaRepository<CorporateDetailDto, Long>{

	@Query("SELECT o from CorporateDetailDto o join UserInfoDto u where u.id=:userId")
	CorporateDetailDto findByUserid(String userId);
	
}
