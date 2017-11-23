package com.mk.ch01.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.ch01.bean.User;
import com.mk.ch01.ioc.UserConfig;


public class TestUserConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		User user = context.getBean(User.class);
		System.out.println(user.getAccount());
		System.out.println(user.getAge());
	}
}