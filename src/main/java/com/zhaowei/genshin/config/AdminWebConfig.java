package com.zhaowei.genshin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zhaowei.genshin.interceptor.LoginInterceptor;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/**")// 所有请求都被拦截
		.excludePathPatterns("/", "/index", "/css/**","/images/**","/js/**");
	}

}
