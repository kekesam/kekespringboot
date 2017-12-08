package com.mengke;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mengke.core.LoginInterceptor;

@Configuration
public class SpringMvcWebAppConfigurer  extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//excludePathPatterns 排除拦截
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**");
	}
   
	
//	@Bean  
//    public FreeMarkerViewResolver freeMarkerViewResolver() {  
//        System.out.println("MvcConfig.freeMarkerViewResolver()");  
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();  
//        resolver.setPrefix("");  
//        resolver.setSuffix(".html");  
//        resolver.setContentType("text/html; charset=UTF-8");  
//        resolver.setRequestContextAttribute("request");  
//        return resolver;  
//    }  
    

}