package com.green.chodoori.main.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfoDto, String> {
	UserInfoDto findByEmail(String email);
}
