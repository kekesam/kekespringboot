package com.mk.ch01.aop.jdk;
import com.mk.ch01.bean.User;
public class UserServiceImpl implements IUserService {
	@Override
	public User login(String account, String password) {
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		System.out.println(account+"用户登录成功了");
		return null;
	}
}
