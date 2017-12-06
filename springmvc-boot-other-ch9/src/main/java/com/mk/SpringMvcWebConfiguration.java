package com.mk;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class SpringMvcWebConfiguration implements WebMvcConfigurer {

	//定义全局URL视图的映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/reg").setViewName("reg");
		//重定向设置
		registry.addRedirectViewController("/redirect", "/index");
	}
	
	//数据格式化处理
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
	}

	//跨域请求设置
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//registry.addMapping("/**");//比较危险，不建议使用。
		registry.addMapping("/cors/**")
		//允许的访问的域名,多个用逗号分隔，这些值都显示在请求头中的Access-Control-Allow-Origin ，"*"代表所有域的请求都支持
		.allowedOrigins("http://www.itbooking.net")
		//预请求的结果的有效期，默认30分钟
		.allowCredentials(false).maxAge(3600)
		//响应头中允许访问的header，默认为空
		//.allowedHeaders("header1", "header2", "header3")
		// 响应头中允许访问的header，默认为空
        //.exposedHeaders("header1", "header2")
        //请求支持的方法，例如"{RequestMethod.GET, RequestMethod.POST}"} 默认支持RequestMapping中设置的方法
		.allowedMethods("POST","GET","PUT","DELETE");
	}

	//拦截器设置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	}

	//静态资源设置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	}

	//对返回的结果集处理
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
	}
	
}
