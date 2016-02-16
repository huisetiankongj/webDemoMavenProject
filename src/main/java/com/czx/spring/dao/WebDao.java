package com.czx.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.czx.base.BaseDao;

@Repository
public class WebDao extends BaseDao implements IWebDao {

	@Override
	public List<Map<String, Object>> findData() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("test1", 1);
		map.put("test2", 2);
		list.add(map);
		return list;
	}

	@Override
	public List<Map<String, Object>> findDBData() {
		StringBuilder sb = new StringBuilder("select COMPANY_NAME,COMPANY_ADDRESS from bid_company");
		return this.getJdbcTemplate().queryForList(sb.toString());
	}
	
	

}
