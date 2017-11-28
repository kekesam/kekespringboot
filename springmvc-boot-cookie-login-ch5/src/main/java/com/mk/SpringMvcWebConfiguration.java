package com.mk;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mk.core.LoginInterceptor;

@SpringBootConfiguration
public class SpringMvcWebConfiguration implements WebMvcConfigurer {

	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(new LoginInterceptor())
		 .addPathPatterns("/success")
		 .addPathPatterns("/user/*")
		 .excludePathPatterns("/user/index");
	}

	//定义全局URL视图的映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
	}
	
}
