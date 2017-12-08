package com.mk.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextDemoListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("监听器进来了...........");
		contextEvent.getServletContext().setAttribute("basePath", "www.itbooking.net");
	}

}
