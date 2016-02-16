package com.czx.spring.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czx.spring.service.ITransactionService;

/**
 * 事务管理
 * http://127.0.0.1:8080/webDemoMavenProject/transaction/delAndUpdate.do
 * 前言知识：
 * 		a)不可重复读的重点是修改 : 同一事务，两次读取到的数据不一样。
 *  	b)幻读的重点在于新增或者删除:同样的条件 ,第 1 次和第 2 次读出来的记录数不一样 
 * 		c)脏读：强调的是第二个事务读到的不够新。 
 * 		d)JPA : Java Persistence API.JPA通过JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中,hibernate是JPA规范的实现方式之一
 * 
 * 
 * 
 * @author admin
 *
 */

@Controller
@RequestMapping("transaction/")
public class TransactionController {

	@Autowired
	private ITransactionService iTransactionService;
	
	@RequestMapping("delAndUpdate")
	public Object delAndUpdate(){
		this.iTransactionService.insertData();
		return null;
	}
	
}
