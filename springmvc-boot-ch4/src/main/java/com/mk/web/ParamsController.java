package com.mk.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.User;

@Controller
public class ParamsController {

	@RequestMapping("/regpage")
	public String reg2() {
		return "reg2";
	}
	
	@ResponseBody
	@PostMapping("/params1")
	public User params1(HttpServletRequest request) {
		String username = request.getParameter("username");
		String account = request.getParameter("account"); 
		String password = request.getParameter("password");
		String male = request.getParameter("male");
		String intro = request.getParameter("intro");
		String hobbys = request.getParameter("hobbys");
		String province = request.getParameter("province");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMale(Integer.parseInt(male));
		user.setIntro(intro);
		user.setHobbys(hobbys);
		user.setProvince(province);
		user.setAccount(account);
		return user;
	}
	
	@ResponseBody
	@PostMapping("/params2")
	public User params2(@RequestParam("username")String username,
			@RequestParam("account")String account,
			@RequestParam("password")String password,
			@RequestParam("male")Integer male,
			@RequestParam("intro")String intro,
			@RequestParam("hobbys")String hobbys,
			@RequestParam("province")String province) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMale(male);
		user.setIntro(intro);
		user.setHobbys(hobbys);
		user.setProvince(province);
		user.setAccount(account);
		return user;
	}
	
	@ResponseBody
	@PostMapping("/params3")
	public User params3(User user) {
		return user;
	}
	
	@ResponseBody
	@GetMapping("/params4/{username}/{password}")
	public String params4(@PathVariable("username")String username,@PathVariable("password")String password) {
		return "你输入的名字是："+username+",密码是："+password;
	}
}
