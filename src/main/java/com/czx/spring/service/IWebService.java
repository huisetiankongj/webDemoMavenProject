package com.czx.spring.service;

import java.util.List;
import java.util.Map;

public interface IWebService {

	public List<Map<String,Object>> findData();
	/**
	 * ��ѯ���ݿ������
	 * @return
	 */
	public List<Map<String,Object>> findDBData();
	
}
