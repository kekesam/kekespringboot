package com.mengke.core;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ServletContextAware;

/**
 * 
 * 获取服务器的根目录
 * TmBasePathExposer<BR>
 * 创建人:梦柯学院-keke <BR>
 * 时间：2015年1月18日-上午12:06:48 <BR>
 * @version 1.0.0
 *
 */
public class TmBasePathExposer implements ServletContextAware {

	private ServletContext servletContext;
	@Value("${keke.path.basepath}")
	private String basePath;
	@Value("${keke.path.imgpath}")
	private String imgPath;

	public void init() {
		servletContext.setAttribute("basePath",basePath);
		servletContext.setAttribute("imgPath",imgPath);
	}

	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
