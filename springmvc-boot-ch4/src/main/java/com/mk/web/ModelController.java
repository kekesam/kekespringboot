package com.mk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mk.bean.User;

@Controller
public class ModelController {

	@GetMapping("/model")
	public String model(Model model) {
		User cuser = new User();
		cuser.setId(1);
		cuser.setAccount("xuke");
		//model.addAttribute(cuser); //与下面的代码等价
		model.addAttribute("user",cuser);
		return "model";
	}
	
	
	@GetMapping("/modelmap")
	public String modelmap(ModelMap modelmap) {
		User cuser = new User();
		cuser.setId(1);
		cuser.setAccount("xuke");
		//modelmap.addAttribute(cuser); //与下面的代码等价
		modelmap.addAttribute("user",cuser);
		return "model";
	}
	
	
	@GetMapping("/modelview")
	public ModelAndView modelview() {
		ModelAndView modelAndView = new ModelAndView();
		User cuser = new User();
		cuser.setId(1);
		cuser.setAccount("xuke");
		//modelAndView.addAttribute(cuser); //与下面的代码等价
		modelAndView.addObject("user",cuser);
		modelAndView.setViewName("model");
		return modelAndView;
	}
	
	@GetMapping("/modelview2")
	public ModelAndView modelview2() {
		ModelAndView modelAndView = new ModelAndView("model");
		User cuser = new User();
		cuser.setId(1);
		cuser.setAccount("xuke");
		modelAndView.addObject("user",cuser);
		return modelAndView;
	}
}
