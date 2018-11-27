package com.lc.platform.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * 如果使用继承.会覆盖掉spring
 * boot原有的自动配置类org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
 * 
 * @author
 * @date
 **/
@Configuration
@Slf4j
public class InterceptorWebConfig
		// extends WebMvcConfigurationSupport
		implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// log.info("Interceptor init succ!");
//		registry.addInterceptor(new JsMapInterceptor()).addPathPatterns("/**/*.map")
		;
	}

}
