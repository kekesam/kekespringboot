package com.mk.ch01.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.ch01.bean.User;

@RestController
public class UserController {
	
	@RequestMapping("/save")
	public String saveUser(User user) {
		return "success";
	}

}
