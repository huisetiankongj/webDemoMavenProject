package com.czx.jquery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jquery/")
public class JqueryDemoController {

	@RequestMapping("self/deferredDemo")
	public Object deferredDemo() {
		return "jquery/self/deferredDemo";
	}
	
}
