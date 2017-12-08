package com.mk.core;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.mk.service.IUserService;


@SpringBootConfiguration
public class UserServiceCxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private IUserService userService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,userService);
        endpoint.publish("/userService");//接口发布在 /userService 目录下
        return endpoint;
    }
}