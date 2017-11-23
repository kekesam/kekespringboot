package com.mk.ch01.aop.jdk;

public class TestUserServiceProxy {

	public static void main(String[] args) {
		//创建代理类
		IUserServiceProxy<IUserService> proxy = new IUserServiceProxy<IUserService>();
		//绑定具体的代理对象
		IUserService userService =  proxy.bind(new UserServiceImpl());
		//执行逻辑
		userService.login("徐柯", "123456");
	}
}
