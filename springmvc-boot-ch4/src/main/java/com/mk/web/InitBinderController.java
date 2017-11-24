package com.mk.web;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.User;

@Controller
public class InitBinderController {
	
	
	@RequestMapping("/bind")
	@ResponseBody
	public User binder(User user) {
		return user;
	}
	
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	*/
}
