package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
//	@Bean
//	public ObjectMapper getObjectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		objectMapper.setDefaultPropertyInclusion(Include.NON_EMPTY);
//		return objectMapper;
//	}
}
