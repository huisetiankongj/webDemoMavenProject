package com.czx.extjs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("extjs/")
public class ExtjsController {

	@RequestMapping("demo")
	public Object demo(HttpSession session, HttpServletRequest request) {
		return "extjs/start";
	}
	
}
