package com.mk.service;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mk.bean.User;
import com.mk.dao.IUserDao;

@WebService(serviceName = "userService"
//和配置类中的UserServiceCxfConfig服务名保持一致
,targetNamespace = "http://webservice.service.mk.com"
//和接口中targetNamespace 定义的保持	一致
,endpointInterface = "com.mk.service.IUserService")
@Service
public class UserviceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

}
