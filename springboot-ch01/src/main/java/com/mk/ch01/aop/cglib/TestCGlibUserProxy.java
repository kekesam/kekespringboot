package com.mk.ch01.aop.cglib;
import com.mk.ch01.aop.jdk.UserServiceImpl;

public class TestCGlibUserProxy {
	public static void main(String[] args) {
		CGlibUserProxy<UserServiceImpl> proxy = new CGlibUserProxy<>();
		UserServiceImpl service = proxy.getInstance(new UserServiceImpl());
		service.login("徐柯", "123456");
	}
}