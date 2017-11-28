package com.mk.core;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mk.bean.User;
import com.mk.mapper.IUserMapper;
import com.mk.service.IUserService;
import com.mk.util.CookieUtils;
import com.mk.util.DateUtil;
import com.mk.util.EncryptionUtil;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("1：满足拦截器规则的方法进入拦截器....");
		//获取登录的用户信息
		User user = (User)request.getSession().getAttribute(MKConstant.SESSSION_USER);
		if(user!=null) {
			return true;
		}
		
		//判断Cookie是否失效，如果没有失效那么直接登录
		// 从cookie中取值  
        Cookie rememberme = CookieUtils.getCookie(request, MKConstant.RememberMe);
        if (rememberme != null) {
        	//对数据解密
        	String cookieValue = EncryptionUtil.base64Decode(rememberme.getValue());
            String[] cValues = cookieValue.split(":");
            if (cValues.length == 2) {
            	String account_cookie = cValues[0]; // 获取用户名
                String ctime = cValues[1]; // 获取UUID值
                //获取上次登录的时间
                Long cLong= Long.parseLong(ctime);
                //获取当前时间
                Date date = new Date();
                //如果当前时间还在7天之内，就直接根据用户名查询登录，否则退出登录
                if(DateUtil.differentDays(new Date(cLong), date) <= 7){
              	  WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
              	  IUserService userService=context.getBean(IUserService.class);
              	  User cookieuser = userService.getLoginByAccount(account_cookie);
              	  request.getSession().setAttribute("session_user", cookieuser);
              	  return true;
                }else{
              	  //删除cookie重新区登录
              	  CookieUtils.delCookie(response, rememberme);
                }
            }
        }
		
		//如果没有登录直接跳转到登录页面
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3：afterCompletion方法必须preHandle返回为true的时候并且在执行完毕Controller方法以后在执行....");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2：postHandle方法必须preHandle返回为true的时候并且在执行Controller方法之前在执行....");
	}
}
