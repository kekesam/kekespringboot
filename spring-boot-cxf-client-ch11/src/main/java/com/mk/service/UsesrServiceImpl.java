package com.mk.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

@Service
public class UsesrServiceImpl implements IUserService {
	
	public Object getUser(Integer id) {
		// 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/userService?wsdl");
        Object[] objects = new Object[0];
        try {
        	// invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUser",id);
            return objects[0];
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
}
