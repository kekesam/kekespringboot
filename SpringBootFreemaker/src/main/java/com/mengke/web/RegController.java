package com.mengke.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mengke.bean.User;
import com.mengke.util.phone.SendCode;

@Controller
public class RegController {

	@RequestMapping("/reg")
	public String reg(){
		return "reg";
	}
	
	@ResponseBody
	@RequestMapping("/sendMsg")
	public String sendMsg(@RequestParam("phone")String telephone,HttpSession session){
		String code = SendCode.sendPone(telephone);
		if(code!=null){
			System.out.println("发送的手机号码是："+code);
			session.setAttribute("phonecode", code);
			return "success";
		}else{
			//短信发送失败
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/regsave",method=RequestMethod.POST)
	public String regsave(User user){
		System.out.println(user);
		//拿到用户输入的code,和发送session中存储的进行比较
		//
		return "success";
	}
}
