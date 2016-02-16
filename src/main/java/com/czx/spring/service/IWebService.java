package com.czx.spring.service;

import java.util.List;
import java.util.Map;

public interface IWebService {

	public List<Map<String,Object>> findData();
	/**
	 * 查询数据库的数据
	 * @return
	 */
	public List<Map<String,Object>> findDBData();
	
}
