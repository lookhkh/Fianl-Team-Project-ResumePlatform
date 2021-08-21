package com.green.chodoori.main.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

@Service
public class ExtractSessionInfoService {

	@Autowired
	ResumeDtoRepo resumeRepo;
	
	@Autowired
	UserInfoRepo userRepo;
	
	public SessionUserInfo extractSessionUserInfo(HttpSession session) {
			
		SessionUserInfo sessionInfo = (SessionUserInfo) session.getAttribute("userInfo");
		String userId = sessionInfo.getId();
		
		
		return sessionInfo;
	}
	
	public String extractUserNameFromSessionInfo(HttpSession session) {
		
		SessionUserInfo sessionInfo = extractSessionUserInfo(session);
		
		return userRepo.findById(sessionInfo.getId()).get().getName();
		
	}
	
	public String extractImgPathFromSessionInfo(HttpSession session) {
		SessionUserInfo sessionInfo = extractSessionUserInfo(session);
		return sessionInfo.getImgPath();
	}
	
	public UserInfoDto extractUserInfoDtoFromSessionInfo(HttpSession session) {
		SessionUserInfo sessionInfo = extractSessionUserInfo(session);
		UserInfoDto dto = userRepo.findById(sessionInfo.getId()).get();
		return dto;
	}
}
