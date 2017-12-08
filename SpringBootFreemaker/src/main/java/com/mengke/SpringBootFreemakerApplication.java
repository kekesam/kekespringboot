package com.mengke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.mengke.core.BasePathExposer;
import com.mengke.core.TmBasePathExposer;

@MapperScan("com.mengke.mapper")
@SpringBootApplication
@ImportResource(locations={"classpath:mykaptcha.xml"})//第二种配置的方式,可以加入xml的配置方式  
public class SpringBootFreemakerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootFreemakerApplication.class, args);
		new SpringApplicationBuilder(SpringBootFreemakerApplication.class)
		.properties("spring.config.name=application,keke")//自动注入属性的方式1
		//.listeners(new LoadAdditionalProperties())//自动注入属性的方式2
	    .run(args);
	}
	
	/**
	 * 初始化跟函数
	 * @return
	 */
	@Bean(initMethod="init")
	public TmBasePathExposer geTmBasePathExposer(){
		return new TmBasePathExposer();
	}
	
	
	@Bean(initMethod="init")
	public BasePathExposer getBasePathExposer(){
		return new BasePathExposer();
	}
	
}