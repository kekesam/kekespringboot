package com.mk.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.mk.bean.User;
@WebService(targetNamespace = "http://webservice.service.mk.com")
public interface IUserService {

	@WebMethod
    public User getUser(@WebParam(name = "id") Integer id);
}
