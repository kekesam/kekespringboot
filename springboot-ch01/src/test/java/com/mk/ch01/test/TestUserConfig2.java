package com.mk.ch01.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.ch01.bean.User;
import com.mk.ch01.ioc.IUserDao;
import com.mk.ch01.ioc.UserConfig;
import com.mk.ch01.ioc.UserDaoImpl;


public class TestUserConfig2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		IUserDao userDao=context.getBean(UserDaoImpl.class);
		List<User> users = userDao.findUsers();
		for (User user : users) {
			System.out.println(user.getAccount());
			System.out.println(user.getAge());
		}
	}
}