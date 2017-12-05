package com.mk.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.User;

@RestController
public class JSONAjaxController {

	
	@RequestMapping("/json")
	public String json() {
		return "success";
	}
	
	@RequestMapping("/json2")
	public Integer json2() {
		return 1;
	}
	
	@RequestMapping("/json3")
	public User json3() {
		User user = new User();
		user.setAccount("xuke");
		user.setAge(31);
		user.setBirthday(new Date());
		user.setUsername("徐柯");
		return user;
	}
	
	@RequestMapping("/json4")
	public HashMap<String, Object> json4() {
		HashMap<String, Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("username", "徐柯");
		map.put("account","xuke");
		map.put("time", new Date());
		return map;
	}
	
	
	@RequestMapping("/json5")
	public List<HashMap<String, Object>> json5() {
		List<HashMap<String, Object>> maps=new ArrayList<>();
		HashMap<String, Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("username", "xuke");
		map.put("account","xuke");
		map.put("time", new Date());
		maps.add(map);
		map=new HashMap<>();
		map.put("id", 2);
		map.put("username", "张三");
		map.put("account","zhangsan");
		map.put("time", new Date());
		maps.add(map);
		return maps;
	}
	
	
	@RequestMapping("/json6")
	public List<User> json6() {
		List<User> users=new ArrayList<>();
		User user = new User();
		user.setAccount("xuke");
		user.setAge(31);
		user.setBirthday(new Date());
		user.setPassword("123456");
		user.setUsername("xuke");
		users.add(user);
		user = new User();
		user.setAccount("zhangsan");
		user.setAge(14);
		user.setBirthday(new Date());
		user.setPassword("123456");
		user.setUsername("张三");
		users.add(user);
		return users;
	}
	
	
}
