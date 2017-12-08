package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mk.servlet.LogFilter;
import com.mk.servlet.LoginServlet;
import com.mk.servlet.ServletContextDemoListener;

@SpringBootApplication
@ServletComponentScan
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<LoginServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<LoginServlet>(new LoginServlet(), "/login");
	}
	
	
	@Bean
	public FilterRegistrationBean<LogFilter> filterRegistrationBean() {
		FilterRegistrationBean<LogFilter> filterRegistrationBean = new FilterRegistrationBean<LogFilter>();
		filterRegistrationBean.setFilter(new LogFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextDemoListener> listenerRegistrationBean(){
		ServletListenerRegistrationBean<ServletContextDemoListener> 
		servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
		servletListenerRegistrationBean.setListener(new ServletContextDemoListener());
		return servletListenerRegistrationBean;
	}
	
}
