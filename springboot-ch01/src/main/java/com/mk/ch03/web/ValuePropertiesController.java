package com.mk.ch03.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValuePropertiesController {

	@Value("${xuke.springboot.path}")
	public String basePath;
	@Value("${xuke.springboot.username}")
	public String username;
	@Value("${xuke.springboot.password}")
	public String password;

	@ResponseBody
	@RequestMapping(value="/value")
	public String valueproperties() {
		return "项目访问根路径是："+basePath+"，姓名是:"+username+",密码是："+password;
	}
}
