package com.mk.ch01.aop.spring.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogProxy {
	
	//定义切入点,拦截com.mk.ch01.aop.spring包下面的所有类下面的save开头的方法
	@Pointcut("execution(* com.mk.ch01.aop.spring..*.save(..))")//-----切点配置1
	//定义切入点,拦截com.mk.ch01.aop.spring包下面的所有类下面的所有方法
	//@Pointcut("execution(* com.mk.ch01.aop.spring..*(..))")//-----切点配置2
	public void executionPointCut() {
		
	}
	
	//注解切点
	@Pointcut("@annotation(com.mk.ch01.aop.spring.annotation.Action)")
	public void annotationPointCut() {
		
	}
	
	
	
	//定义通知Advice,定义前置通知
	@Before("executionPointCut() || annotationPointCut() ")
	public void before(JoinPoint point) {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method=signature.getMethod();
		System.out.println("执行的方法是："+method.getName()+"*********************在执行方法之前保存日记");
	}
	
	//定义通知Advice,定义后置通知
	@After("executionPointCut() || annotationPointCut()")
	public void after(JoinPoint point) {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method=signature.getMethod();
		System.out.println("执行的方法是："+method.getName()+"*********************在执行方法之后保存日记");
	}
	
	
}
