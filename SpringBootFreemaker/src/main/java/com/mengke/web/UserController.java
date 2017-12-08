package com.mengke.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mengke.bean.TmParams;
import com.mengke.bean.User;
import com.mengke.mapper.IUserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	

	@Autowired
	private IUserMapper userMapper;
	
	@RequestMapping("/list")
	public String list(Model model,TmParams params){
		int itemCount = userMapper.countUsers(params);
		model.addAttribute("itemCount", itemCount);
		return "user/list";
	}
	
	
	@ResponseBody
	@RequestMapping("/delete/{id}")
	public String list(@PathVariable("id")String id){
		userMapper.deluser(id);
		return "success";
	}
	
	@RequestMapping(value="/template")
	public String template(Model model,TmParams params){
		List<User> users = userMapper.findUsers(params);
		int itemCount = userMapper.countUsers(params);
		model.addAttribute("itemCount", itemCount);
		model.addAttribute("users", users);
		return "user/template";
	}
	
}
