package com.mk.ch01.ioc;

import java.util.List;

import com.mk.ch01.bean.User;

public interface IUserDao {

	public List<User> findUsers();
}
