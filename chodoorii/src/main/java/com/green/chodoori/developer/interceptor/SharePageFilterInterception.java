package com.green.chodoori.developer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SharePageFilterInterception implements HandlerInterceptor {

	final private ExtractSessionInfoService sessionExtractor;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		SessionUserInfo userInfo = sessionExtractor.extractSessionUserInfo(session);
		
		if(userInfo.getSort()==1) {
		    
			
			String referer = request.getHeader("Referer")+"?error=onlyDev";
			log.info("기업회원이 접근 시도, {}로 리다이렉트",referer);
			
			
			response.sendRedirect(referer);
			return false;
		}
		
		if(userInfo.getCheck() == 1) {
			
			log.info("일반회원이 접근 시도, 그러나 이력서 존재 x resume로 리다이렉트");

			response.sendRedirect("/resume?error=noResume");
			return false;

		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
