package com.mk.ch01.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mk.ch01.bean.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@Override
	public List<User> findUsers() {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setAccount("徐柯");
		user.setAge(30);
		users.add(user);
		user = new User();
		user.setAccount("张三");
		user.setAge(21);
		users.add(user);
		return users;
	}

}
