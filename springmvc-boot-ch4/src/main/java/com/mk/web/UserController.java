package com.mk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	

	@ResponseBody
	@RequestMapping("/test")
	public String rest() {
		return "访问http://localhost:8080/user/test，在页面上直接输出哦！";//4
	}
	
}
