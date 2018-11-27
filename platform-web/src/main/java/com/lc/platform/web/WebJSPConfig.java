package com.lc.platform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.lc.platform.common.util.CommonUtil;

@Configuration
public class WebJSPConfig implements WebMvcConfigurer {
	@Autowired
	private WebMvcProperties mvcProperties;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
		if (CommonUtil.isNotEmpty(this.mvcProperties.getView().getPrefix())) {
			resolver.setPrefix(this.mvcProperties.getView().getPrefix());
		} else {
			resolver.setPrefix("/pages/");
		}
		if (CommonUtil.isNotEmpty(this.mvcProperties.getView().getSuffix())) {
			resolver.setSuffix(this.mvcProperties.getView().getSuffix());
		} else {
			resolver.setSuffix(".jsp");
		}
		registry.viewResolver(resolver);
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**")
	// .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
	// }
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/").setViewName("forward:/index.jsp");
	// registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	// }
}
