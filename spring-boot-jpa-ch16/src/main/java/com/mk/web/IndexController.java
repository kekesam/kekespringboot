package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.bean.User;
import com.mk.dao.UserRepository;

@Controller
public class IndexController {

	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@RequestMapping("/index")
	public String index() {
		User user = new User();
		user.setUsername("keke");
		user.setUserpwd("1234567");
		user = userRepository.save(user);
		return "index";
	}
}
