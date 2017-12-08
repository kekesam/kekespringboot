package com.mengke.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengke.bean.User;


@Controller
@RequestMapping("/admin")
public class IndexController {
	
	@RequestMapping("/list")
	public String list(){
		return "page/list";
	}

	@RequestMapping("/freemaker")
	public String freemaker(Model model){
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setBirthday(new Date());
		user.setMale(1);
		user.setUsername("keke");
		users.add(user);
		
		user = new User();
		user.setId(2);
		user.setBirthday(new Date());
		user.setMale(0);
		user.setUsername("龙龙");
		users.add(user);
		
		user = new User();
		user.setId(3);
		user.setBirthday(new Date());
		user.setMale(2);
		user.setUsername(null);
		users.add(user);
		
		model.addAttribute("users", users);
		model.addAttribute("course","");
		return "freemaker";
	}
	

	@RequestMapping("/index")
	public String index(Model model){
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setBirthday(new Date());
		user.setUsername("keke");
		users.add(user);
		
		user = new User();
		user.setId(2);
		user.setBirthday(new Date());
		user.setUsername(null);
		users.add(user);
		
		
		model.addAttribute("users", users);
		return "index";
	}
}
