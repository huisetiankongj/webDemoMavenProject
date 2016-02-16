package com.czx.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器有多中实现方法
 * 1、直接使用filter
 * 2、spirng aop也可以实现
 * 
 * 如果是设置编码过滤器的话，spring有内置的过滤器
 * @author admin
 *
 */


//模仿spring CharacterEncodingFilter类
public class CharacterEncodingFilter implements Filter{

	private String encoding;
	
	private boolean forceEncoding = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取web.xml的init-param
		if(filterConfig.getInitParameter("forceEncoding")!=null)
			forceEncoding = Boolean.parseBoolean(filterConfig.getInitParameter("forceEncoding"));
		if(filterConfig.getInitParameter("encoding")!=null)
			encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * request的getParamter里面的中文乱码是无法设置的
		 * 只能通过tomcat设置utf-8或者直接通过new String(getParamter("t").toString().getBytes("ISO8859-1"),"UTF-8");
		 */
		if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
				response.setCharacterEncoding(this.encoding);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
