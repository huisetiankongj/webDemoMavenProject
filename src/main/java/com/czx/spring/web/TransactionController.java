package com.czx.spring.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czx.spring.service.ITransactionService;

/**
 * �������
 * http://127.0.0.1:8080/webDemoMavenProject/transaction/delAndUpdate.do
 * ǰ��֪ʶ��
 * 		a)�����ظ������ص����޸� : ͬһ�������ζ�ȡ�������ݲ�һ����
 *  	b)�ö����ص�������������ɾ��:ͬ�������� ,�� 1 �κ͵� 2 �ζ������ļ�¼����һ�� 
 * 		c)�����ǿ�����ǵڶ�����������Ĳ����¡� 
 * 		d)JPA : Java Persistence API.JPAͨ��JDK 5.0ע���XML�������󣭹�ϵ���ӳ���ϵ�����������ڵ�ʵ�����־û������ݿ���,hibernate��JPA�淶��ʵ�ַ�ʽ֮һ
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
