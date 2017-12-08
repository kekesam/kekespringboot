package com.mengke.core;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ServletContextAware;

public class BasePathExposer implements ServletContextAware{
	
	private ServletContext application;
	@Value("${keke.path.basepath}")
	private String basePath;
	@Value("${keke.path.imgpath}")
	private String imgPath;
	
	public void init(){
		application.setAttribute("basePath", basePath);
		application.setAttribute("imgPath", imgPath);
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}
}
