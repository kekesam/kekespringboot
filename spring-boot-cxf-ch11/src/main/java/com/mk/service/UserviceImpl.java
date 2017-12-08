package com.mk.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bean.User;
import com.mk.dao.IUserDao;

@WebService(serviceName = "userService"//服务名
,targetNamespace = "http://webservice.service.mk.com"//报名倒叙，并且和接口定义保持一致
,endpointInterface = "com.mk.service.IUserService")//包名
@Service
public class UserviceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

}
