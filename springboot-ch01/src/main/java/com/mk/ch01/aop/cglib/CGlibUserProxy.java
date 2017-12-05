package com.mk.ch01.aop.cglib;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
public class CGlibUserProxy<T> implements MethodInterceptor {

	// 创建代理对象
	private T target;

	public T getInstance(T target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		//回掉方法
		enhancer.setCallback(this);;
		//创建代理对象
		return (T) enhancer.create();
	}

	@Override
	public T intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("*********我是CGLib代理********");
		//反射调用方法前执行逻辑
		System.out.println("登陆之前执行的逻辑.....");
		Object obj = proxy.invokeSuper(object, args);
		System.out.println("登陆之后执行的逻辑.....");
		return (T) obj;
	}
}