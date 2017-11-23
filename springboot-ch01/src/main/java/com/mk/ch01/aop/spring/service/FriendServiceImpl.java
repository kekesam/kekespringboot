package com.mk.ch01.aop.spring.service;

import org.springframework.stereotype.Service;

import com.mk.ch01.aop.spring.annotation.Action;

@Service
public class FriendServiceImpl implements IFriendService {

	@Override
	public void save() {
		System.out.println("save-------->好友");
	}

	@Override
	public void find() {
		System.out.println("find-------->好友");
	}

	@Override
	public void delete() {
		System.out.println("delete-------->好友");
	}

	@Override
	public void update() {
		System.out.println("update-------->好友");
	}

	@Action(name = "我是一个注解的AOP标记，写了我就会被拦截哦!")
	public void findFreiends() {
		System.out.println("findFreiends------------>查找好友");
	}
	
	public void deleteFriend() {
		System.out.println("deleteFriend------------>删除好友");
	}
}
