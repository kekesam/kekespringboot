package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mk.service.IUserService;

@Controller
//@SessionAttributes(types= {User.class})
@SessionAttributes(value= {"user","course"})
public class SessionAttributeController {
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/session")
	public String session() {
		return "session";
	}

	@GetMapping("/sessionattr/{id}")
	public String model(@PathVariable("id")Integer id,Model model) {
		//判断model中是否包含user,
		model.addAttribute("user", userService.getUser(id));
		return "redirect:/session";
	}
	
}
