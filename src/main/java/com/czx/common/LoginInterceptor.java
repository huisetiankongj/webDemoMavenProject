package com.czx.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.czx.user.po.User;

public class LoginInterceptor implements HandlerInterceptor{

	private String ingoreUriExgex;
	
	public String getIngoreUriExgex() {
		return ingoreUriExgex;
	}

	public void setIngoreUriExgex(String ingoreUriExgex) {
		this.ingoreUriExgex = ingoreUriExgex;
	}
	/**
	 * ����֮ǰ
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();
		if(!requestURI.matches(ingoreUriExgex)){
			User user = new User();
            user.setName("admin");
            user.setPassword("123456");
            request.getSession().setAttribute("currentUser", user);
		}
		return true;
	}

	/**
	 * ����֮��
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * ������ɺ�
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
