package com.mk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mk.bean.User;
import com.mk.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmvcBootCh4ApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Test
	public void contextLoads() {
		User user = userService.getUser(1);
		System.out.println(user.getId());
		System.out.println(user.getAccount());
		System.out.println(user.getUsername());
	}

}
