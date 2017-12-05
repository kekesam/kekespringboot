package com.mk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//1:实现WebApplicationInitializer接口，完成对零配置的配置，将取代web.xml
public class WebInitalizerConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		//获取spring的AnnotationConfigWebApplicationContext容器对象。
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//注册SpringMvc的配置，到Spring容器中进行初始化和管理
		context.register(SpringMvcConfig.class);
		//将context和application作用域进入管理
		context.setServletContext(servletContext);
		
		//配置springmvc的核心servletDispatcherServlet
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		//拦截路径是/
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

}
