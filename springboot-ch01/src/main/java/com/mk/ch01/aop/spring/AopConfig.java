package com.mk.ch01.aop.spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration//------>标注为配置类
@ComponentScan(basePackages="com.mk.ch01.aop.spring")//----->注册aop的代理配置
@EnableAspectJAutoProxy//----->启动spring的aspectj的方式aop
public class AopConfig {

}
