package com.green.chodoori.resume.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SharedMyResumeInfoDtoRepo extends JpaRepository<SharedMyResumeInfoDto, Long> {
	
	
	//List<SharedMyResumeInfoDtoRepo> findByRegisterDateAfter(Date date);

	//@Query("SELECT o from SharedMyResumeInfoDto o"
	//	+  "join o.userInfoDto u where u.name=:userId")
	//SharedMyResumeInfoDtoRepo findbyUserName(String userId);
	
	
}
