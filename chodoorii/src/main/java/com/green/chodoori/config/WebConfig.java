package com.green.chodoori.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.green.chodoori.main.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    	LoginInterceptor loginIntercepter = new LoginInterceptor();
        registry.addInterceptor(loginIntercepter)
                .addPathPatterns("/resume/**","/corporate/**")
        		.excludePathPatterns("/corporate/detail/*");

    }
}
	

