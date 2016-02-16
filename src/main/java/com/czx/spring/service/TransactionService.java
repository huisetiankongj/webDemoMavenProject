package com.czx.spring.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.czx.spring.dao.ITransactionDao;
@Service
public class TransactionService implements ITransactionService {

//	@Resource(name="demo.transactionDao")
	@Autowired
	private ITransactionDao iTransactionDao;
	
	public ITransactionDao getiTransactionDao() {
		return iTransactionDao;
	}

	public void setiTransactionDao(ITransactionDao iTransactionDao) {
		this.iTransactionDao = iTransactionDao;
	}
	

	@Override
	public void delData() {
		this.iTransactionDao.delData();
	}

	@Override
	public void updateData() {
		this.iTransactionDao.updateData();
	}

	@Override
	@Transactional
	public void insertData() {
		// TODO Auto-generated method stub
		this.iTransactionDao.insertData();
		this.iTransactionDao.updateData();
		this.iTransactionDao.delData();
	}

}
