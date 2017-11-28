package com.mk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.mk.mapper")
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}

}
