package com.mk.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.User;
import com.mk.core.MKConstant;
import com.mk.service.IUserService;
import com.mk.util.CookieUtils;
import com.mk.util.EncryptionUtil;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;

	//进入登陆页面
	@RequestMapping("/login")
	public String login(HttpSession session) {
		User user = (User) session.getAttribute(MKConstant.SESSSION_USER);
		if(user!=null) {
			return "redirect:/success";
		}else {
			return "login";
		}
	}
	
	//登陆成功页面
	@RequestMapping("/success")
	public String success() {
		System.out.println("==============>success方法被拦截处理了");
		return "success";
	}
	

	//登录逻辑
	@ResponseBody
	@PostMapping("/logined")
	public String logined(@RequestParam("account")String account,@RequestParam("password")String password,
			@RequestParam("remember")Integer remember,HttpSession session,HttpServletResponse response) {
		User user = userService.getLoginUser(account, password);
		if(user!=null) {
			if(remember!=null && remember==1){
				long ctime = new Date().getTime();
	            // Cookie值
	            String cookieValue = EncryptionUtil.base64Encode(user.getAccount()+":"+ctime);
	            // 保存cookie
	            CookieUtils.addCookie(response, MKConstant.RememberMe, cookieValue, null);
			}
			//放入到sesssion中。
			session.setAttribute(MKConstant.SESSSION_USER, user);
			return "success";
		}
		return "fail";
	}
	
	
	@RequestMapping("/logout")
	public String logined(HttpServletRequest request,HttpServletResponse response) {
		//清除session和用于自动登录的cookie
		CookieUtils.delCookie(request, response, MKConstant.RememberMe);
		request.getSession().invalidate();
		return "redirect:login";
	}
}
