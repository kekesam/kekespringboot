package com.mk.dao;

import java.util.List;

import com.mk.bean.User;

public interface IUserDao {
	//查询用户
	public List<User> findUsers();
	//查询用户明细
	public User getUser(Integer id);
	//保存用户信息
	public int saveUser(User user);
	//更新用户信息
	public int updateUser(User user);
	//删除用户信息
	public int deleteUser(Integer id);
}
