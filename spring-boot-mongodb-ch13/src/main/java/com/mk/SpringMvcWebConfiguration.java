package com.mk;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class SpringMvcWebConfiguration implements WebMvcConfigurer {

	//定义全局URL视图的映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
	}
	
}
