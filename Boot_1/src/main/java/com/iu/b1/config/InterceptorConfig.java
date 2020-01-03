package com.iu.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.b1.interceptor.CustomInterceptor;

@Configuration //xml
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Interceptor 등록
		registry.addInterceptor(customInterceptor)
		//Interceptor를 사용할 URL 등록
		.addPathPatterns("/member/*")
//		.addPathPatterns("/member/memberPage");
		//Interceptro를 제외할 URL 등록
		.excludePathPatterns("/member/memberLogin")
		.excludePathPatterns("/member/memberJoin");
		
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
