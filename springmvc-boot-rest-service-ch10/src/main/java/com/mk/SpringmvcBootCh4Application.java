package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//通用实例化RestTemplate
@SpringBootApplication
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplateBuilder builder = new RestTemplateBuilder();
		return builder.build();
	}
}
