package com.green.chodoori.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.green.chodoori.main.web.domain.SessionUserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("세션 인터셉터 실행");

		HttpSession session = request.getSession();
		
		SessionUserInfo user =  (SessionUserInfo) session.getAttribute("userInfo");
		String requestedUrl = request.getServletPath().toString();
		
		log.info("인터셉터 정보 ==> 요청 URL : {}",requestedUrl);
		
		
		if(user==null) {
			response.sendRedirect("/?loginRedirect="+requestedUrl);
			return false;
		}
		return true;
	}
}
