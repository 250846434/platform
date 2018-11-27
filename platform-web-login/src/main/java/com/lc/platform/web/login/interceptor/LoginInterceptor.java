package com.lc.platform.web.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lc.platform.web.login.annotation.IgnoreLogin;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author
 * @date
 **/
@Configuration
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("测试拦截器!");
		//ResourceHttpRequestHandler
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		IgnoreLogin annotation = handlerMethod.getMethodAnnotation(IgnoreLogin.class);
		if (annotation == null) {
			HttpSession session = request.getSession();
			Object user = session.getAttribute("user");
			if (user == null) {
				response.sendRedirect("/login");
				return false;
			}
			log.info("user name is :{}", user);
			// session.setAttribute("user","test");
		}
		return super.preHandle(request, response, handler);
	}
}
