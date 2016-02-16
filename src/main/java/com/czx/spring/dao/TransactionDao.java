package com.czx.spring.dao;

import org.springframework.stereotype.Repository;

import com.czx.base.BaseDao;

@Repository
public class TransactionDao extends BaseDao implements ITransactionDao {

	@Override
	public void delData() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("delete from asset1 where id='6'");
		this.getJdbcTemplate().update(sb.toString());
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("update asset set assetName='czx' where id='6'");
		this.getJdbcTemplate().update(sb.toString());
	}

	@Override
	public void insertData() {
		StringBuilder sb = new StringBuilder("insert into asset (assetNum,assetName)values('czx','czx')");
		this.getJdbcTemplate().update(sb.toString());
	}
}
