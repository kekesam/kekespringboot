package com.mk.dao;

import java.util.List;

import com.mk.bean.User;

public interface IUserService {

	public User save(User user);
	public User update(User user);
	public User delete(User user);
	public List<User> findAll();
}
