package com.mk.ch03.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyConfigPropertiesController {


	@Autowired
	private ValueConfigProperties properties;
	
	@ResponseBody
	@RequestMapping(value="/myvalue")
	public String valueproperties() {
		return "项目访问根路径是："+properties.getPath()+"，姓名是:"+properties.getUsername()+",密码是："+properties.getPassword()+"地址是："+properties.getAddress()+"===年龄是："+properties.getAge();
	}
}
