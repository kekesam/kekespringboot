package com.mk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bean.User;
import com.mk.mapper.IUserMapper;
import com.mk.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserMapper userMapper;

	@Override
	public User getUser(Integer id) {
		return userMapper.getUser(id);
	}

	@Override
	public User getLoginUser(String account, String password) {
		return userMapper.getLoginUser(account, password);
	}

	@Override
	public User getLoginByAccount(String account) {
		return userMapper.getLoginByAccount(account);
	}
}