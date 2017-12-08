package com.mk.mapper;

import org.apache.ibatis.annotations.Param;

import com.mk.bean.User;

public interface IUserMapper {
	
	/**
	 * 
	 * 根据id查询用户信息
	 * 方法名：getUser<br/>
	 * 创建人：xuke <br/>
	 * 时间：2017年11月26日-下午2:44:39 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return User<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User getUser(Integer id);
	
	/**
	 * 
	 * 根据账号和密码登录
	 * 方法名：getLoginUser<br/>
	 * 创建人：xuke <br/>
	 * 时间：2017年11月26日-下午2:44:16 <br/>
	 * 手机:15074816437<br/>
	 * @param account
	 * @param password
	 * @return User<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User getLoginUser(@Param("account")String account,@Param("password")String password);
	
	/**
	 * 
	 * 根据账号查询用户信息，用于Cookie查询信息
	 * 方法名：getLoginUser<br/>
	 * 创建人：xuke <br/>
	 * 时间：2017年11月26日-下午4:43:50 <br/>
	 * 手机:15074816437<br/>
	 * @param account
	 * @return User<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User getLoginByAccount(@Param("account")String account);
}
