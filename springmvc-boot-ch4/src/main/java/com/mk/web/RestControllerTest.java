package com.mk.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")//2
public class RestControllerTest {
	
	@RequestMapping("/test")//3
	public String rest() {
		return "访问http://localhost:8080/rest/test，在页面上直接输出哦！";//4
	}
	
}
