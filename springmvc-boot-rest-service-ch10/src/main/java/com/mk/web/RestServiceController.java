package com.mk.web;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.User;


@RestController
public class RestServiceController {

	@PostMapping("/service/{id}")
	public User getUser(@PathVariable("id")Integer id) {
		System.out.println("接受到了参数id是:"+id);
		User user = new User();
		user.setId(id);
		user.setUsername("xuke");
		user.setPassword("12345677");
		return user;
	}
	
	@GetMapping("/service2/{id}")
	public HashMap<String, Object> getUserMap(@PathVariable("id")Integer id) {
		System.out.println("接受到了参数id是:"+id);
		HashMap<String, Object> map=new HashMap<>();
		map.put("id", id);
		map.put("usename", "xuke");
		map.put("password", "1234565");
		return map;
	}
}
