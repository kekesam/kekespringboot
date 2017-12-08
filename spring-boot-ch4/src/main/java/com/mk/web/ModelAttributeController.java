package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.User;
import com.mk.service.IUserService;

@Controller
public class ModelAttributeController {
	
	
	@Autowired
	private IUserService userService;
	
	@ModelAttribute
	public void getUser(@PathVariable("id")Integer id,Model model) {
		model.addAttribute("user", userService.getUser(id));
	}
	
	@ModelAttribute
	public User getUser(@PathVariable("id")Integer id) {
		return  userService.getUser(id);
	}

	@GetMapping("/attr/{id}")
	@ResponseBody
	public String model(Model model) {
		//判断model中是否包含user,
		System.out.println(model.containsAttribute("user"));
		return "success";
	}
	
}
