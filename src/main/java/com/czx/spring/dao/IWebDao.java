package com.czx.spring.dao;

import java.util.List;
import java.util.Map;

public interface IWebDao {

	public List<Map<String,Object>> findData();
	
	public List<Map<String,Object>> findDBData();
}
