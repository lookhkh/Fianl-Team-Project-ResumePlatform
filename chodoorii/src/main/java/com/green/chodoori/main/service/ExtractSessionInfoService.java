package com.green.chodoori.main.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;

@Service
public class ExtractSessionInfoService {

	@Autowired
	ResumeDtoRepo resumeRepo;
	
	public SessionUserInfo extractSessionUserInfo(HttpSession session) {
			
		SessionUserInfo sessionInfo = (SessionUserInfo) session.getAttribute("userInfo");
		String userId = sessionInfo.getId();
		
		
		return sessionInfo;
	}
}
