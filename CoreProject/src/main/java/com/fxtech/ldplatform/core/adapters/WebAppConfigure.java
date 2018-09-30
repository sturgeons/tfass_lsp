package com.fxtech.ldplatform.core.adapters;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fxtech.ldplatform.core.interceptors.ErrorInterceptor;

@Configuration
public class WebAppConfigure extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截器规则
		// excluePathPatters 用于排除拦截规则
		registry.addInterceptor(new ErrorInterceptor());

		super.addInterceptors(registry);
	}
}
