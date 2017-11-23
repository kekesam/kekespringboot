package com.mk.ch01.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IUserServiceProxy<T> implements InvocationHandler {
	
	//定义服务对象
	private Object target;

	/**
	 * 通过代理对象首先进入这个方法
	 * @param proxy--代理对象
	 * @param method 被调用方法
	 * @param args 方法的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public T invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("*********************我是JDK的动态代理.*******************");
		Object result = null;
		//织入代码逻辑
		System.out.println("登陆之前执行的逻辑在这里..........");
		//执行具体的逻辑方法--反射调用方法
		result = method.invoke(target, args);
		//织入逻辑执行之后的逻辑
		System.out.println("登录执行完毕执行的逻辑在这里.......");
		return (T) result;
	}
	
	/**
	 * 绑定委托并且返回一个代理类
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public T bind(T target) {
		this.target = target;
		//产生代理对象
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
