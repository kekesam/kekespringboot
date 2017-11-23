package com.mk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//1:ʵ��WebApplicationInitializer�ӿڣ���ɶ������õ����ã���ȡ��web.xml
public class WebInitalizerConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		//��ȡspring��AnnotationConfigWebApplicationContext��������
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//ע��SpringMvc�����ã���Spring�����н��г�ʼ���͹���
		context.register(SpringMvcConfig.class);
		//��context��application������������
		context.setServletContext(servletContext);
		
		//����springmvc�ĺ���servletDispatcherServlet
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		//����·����/
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

}
