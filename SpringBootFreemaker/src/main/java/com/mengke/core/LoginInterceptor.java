package com.mengke.core;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mengke.bean.User;
import com.mengke.mapper.IUserMapper;
import com.mengke.util.cookie.CookieConstantTable;
import com.mengke.util.cookie.CookieUtils;
import com.mengke.util.cookie.DateUtil;
import com.mengke.util.cookie.EncryptionUtil;

public class LoginInterceptor implements HandlerInterceptor{


	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*User user = (User) request.getSession().getAttribute("session_user");
		if(user==null){
			// 从cookie中取值  
            Cookie rememberme = CookieUtils.getCookie(request, CookieConstantTable.RememberMe);
            if (rememberme != null) {
            	String cookieValue = EncryptionUtil.base64Decode(rememberme.getValue());
                String[] cValues = cookieValue.split(":");
                if (cValues.length == 2) {
                	  String account_cookie = cValues[0]; // 获取用户名
                      String ctime = cValues[1]; // 获取UUID值
                      //获取上次登录的时间
                      Long cLong= Long.parseLong(ctime);
                      //获取当前时间
                      Date date = new Date();
                      //如果当前时间还在30天之内，就直接根据用户名查询登录，否则退出登录
                      if(DateUtil.differentDays(new Date(cLong), date) <=30){
                    	  WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    	  IUserMapper userMapper=context.getBean(IUserMapper.class);
                    	  User cookieuser = userMapper.getLoginByAccount(account_cookie);
                    	  request.getSession().setAttribute("session_user", cookieuser);
                      }else{
                    	  //删除cookie重新区登录
                    	  CookieUtils.delCookie(response, rememberme);
                    	  response.sendRedirect(request.getContextPath()+"/login");
                      }
                }
            	return true;
            }else{
            	response.sendRedirect(request.getContextPath()+"/login");
            	return false;
            }
		}else{
			return true;
		}*/
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("preHandle==true----->在拦截进入controller方法之前执行的方法");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("preHandle==true----->在处理完controller方法之后执行的方法");
	}
	
	

}
