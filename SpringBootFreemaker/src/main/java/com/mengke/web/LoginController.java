package com.mengke.web;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mengke.bean.User;
import com.mengke.mapper.IUserMapper;
import com.mengke.util.MD5PwdUtil;
import com.mengke.util.cookie.CookieConstantTable;
import com.mengke.util.cookie.CookieUtils;
import com.mengke.util.cookie.EncryptionUtil;

@Controller
public class LoginController {
	
	@Autowired
	private IUserMapper userMapper;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		//清除session和用于自动登录的cookie
		CookieUtils.delCookie(request, response, CookieConstantTable.RememberMe);
		request.getSession().invalidate(); 
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(@RequestParam("account")String account,
			@RequestParam("password")String password,
			@RequestParam("rememberMe")String rememberMe
			,HttpSession session,HttpServletResponse response){
		User user2 = userMapper.getLogin(account,MD5PwdUtil.md5Base64(password));
		// 如果rememberme为true，则保存cookie值，下次自动登录
		if(user2!=null && rememberMe.equals("1")){
			 // 有效期
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, 1); // 一个月
            long ctime = new Date().getTime();
            // Cookie值
            String cookieValue = EncryptionUtil.base64Encode(user2.getAccount()+":"+ctime);
            // 保存cookie
            CookieUtils.addCookie(response, CookieConstantTable.RememberMe, cookieValue, null);
			session.setAttribute("session_user", user2);
			return "success";
		}else{
			return "fail";
		}
	}
	
	
/*	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(@RequestParam("account")String account,
			@RequestParam("password")String password,
			@RequestParam("rememberMe")String rememberMe
			,HttpSession session){
		User user2 = userMapper.getLogin(account,MD5PwdUtil.md5Base64(password));
		if(user2!=null){
			session.setAttribute("session_user", user2);
			return "success";
		}else{
			return "fail";
		}
	}
*/}
