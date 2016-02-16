package com.czx.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czx.spring.dao.IWebDao;

@Service
public class WebService implements IWebService {

	@Autowired
	private IWebDao webDao;
	
	@Override
	public List<Map<String, Object>> findData() {
		return webDao.findData();
	}

	@Override
	public List<Map<String, Object>> findDBData() {
		return webDao.findDBData();
	}

}
