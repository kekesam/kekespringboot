package com.mk.ch01.aop.spring.service;

import org.springframework.stereotype.Service;

import com.mk.ch01.aop.spring.annotation.Action;

@Service
public class RegServiceImpl implements IRegService {

	@Override
	public void save() {
		System.out.println("save-------->用户");
	}

	@Override
	public void find() {
		System.out.println("find-------->用户");
	}

	@Override
	public void delete() {
		System.out.println("delete-------->用户");
	}

	@Override
	public void update() {
		System.out.println("update-------->用户");
	}
	
	@Action(name = "我是一个注解的AOP标记，写了我就会被拦截哦!")
	public void findUsers() {
		System.out.println("findUsers------------>查找用户");
	}
	
	public void deleteUser() {
		System.out.println("deleteUser------------>删除用户");
	}

}
