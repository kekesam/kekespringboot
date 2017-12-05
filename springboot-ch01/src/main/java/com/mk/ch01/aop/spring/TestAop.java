package com.mk.ch01.aop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.ch01.aop.spring.service.IFriendService;
import com.mk.ch01.aop.spring.service.IRegService;

public class TestAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		System.out.println("====================IRegService====================");
		IRegService regService =  context.getBean(IRegService.class);
		regService.save();
		regService.find();
		regService.delete();
		regService.update();
		regService.findUsers();//注解 Action拦截
		regService.deleteUser();
		System.out.println("====================IRegService====================");
		IFriendService friendService=  context.getBean(IFriendService.class);
		friendService.save();
		friendService.find();
		friendService.delete();
		friendService.update();
		friendService.findFreiends();//注解 Action拦截
		friendService.deleteFriend();
	}
}
