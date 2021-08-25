package com.green.chodoori.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.green.chodoori.developer.interceptor.SharePageFilterInterception;
import com.green.chodoori.main.interceptor.LoginInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

	final private LoginInterceptor loginIntercepter;
	final private SharePageFilterInterception sharePageFilterInterception;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginIntercepter)
                .addPathPatterns("/resume/**","/corporate/**")
        		.excludePathPatterns("/corporate/detail/*","/corporate/cpinfo/**");

        
        registry.addInterceptor(sharePageFilterInterception)
        		.addPathPatterns("/resume/share/**");
    }
    
    
}
	

