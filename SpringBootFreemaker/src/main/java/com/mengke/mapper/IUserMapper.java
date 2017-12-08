package com.mengke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mengke.bean.TmParams;
import com.mengke.bean.User;

public interface IUserMapper {
	
	/**
	 * 定义查询用户方法
	 * @return
	 */
	public List<User> findUsers(TmParams params);
	public int countUsers(TmParams params);
	
	
	public int deluser(@Param("id")String id);
	
	/**
	 * 根据用户名和密码登录
	 * @param account
	 * @param password
	 * @return
	 */
	public User getLogin(@Param("account")String account,
			@Param("password")String password);
	
	public User getLoginByAccount(@Param("account")String account);
}
