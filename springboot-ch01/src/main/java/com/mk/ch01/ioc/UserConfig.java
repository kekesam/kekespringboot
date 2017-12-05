package com.mk.ch01.ioc;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mk.ch01.bean.User;
@SpringBootConfiguration
@ComponentScan("com.mk.ch01.ioc")
public class UserConfig {
	
	
	@Bean
	public IUserDao getUserDao(){
		return new UserDaoImpl();
	}
	
	
	@Bean
	public User getUser() {
		User user = new User();
		user.setAccount("xuke");
		user.setAge(30);
		return user;
	}
	
	
}