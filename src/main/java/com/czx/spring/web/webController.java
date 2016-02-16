package com.czx.spring.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czx.spring.service.IWebService;
/**
 * spring 注解方式的调用
 * http://127.0.0.1:8080/webDemoMavenProject/web/findData.do
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/")
public class webController {

	@Autowired
	private IWebService webService;
	
	@RequestMapping("findData")
	@ResponseBody
	public Object findData(){
		List<Map<String,Object>> list = this.webService.findData();
		return list;
	}
	@RequestMapping("findDBData")
	@ResponseBody
	public Object findDBData(){
		List<Map<String,Object>> list = this.webService.findDBData();
		return list;
	}
}
