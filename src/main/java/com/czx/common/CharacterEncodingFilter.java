package com.czx.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * �������ж���ʵ�ַ���
 * 1��ֱ��ʹ��filter
 * 2��spirng aopҲ����ʵ��
 * 
 * ��������ñ���������Ļ���spring�����õĹ�����
 * @author admin
 *
 */


//ģ��spring CharacterEncodingFilter��
public class CharacterEncodingFilter implements Filter{

	private String encoding;
	
	private boolean forceEncoding = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��ȡweb.xml��init-param
		if(filterConfig.getInitParameter("forceEncoding")!=null)
			forceEncoding = Boolean.parseBoolean(filterConfig.getInitParameter("forceEncoding"));
		if(filterConfig.getInitParameter("encoding")!=null)
			encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * request��getParamter����������������޷����õ�
		 * ֻ��ͨ��tomcat����utf-8����ֱ��ͨ��new String(getParamter("t").toString().getBytes("ISO8859-1"),"UTF-8");
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
