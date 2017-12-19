package com.mk;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mk.bean.User;
import com.mk.dao.UserService;

import net.sf.ehcache.CacheManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationCacheTests {
	
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private UserService userService;
	
	
	@Test
	public void findAll() {
		System.out.println("第一次查询:");
		List<User> users = userService.findUsers();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		System.out.println("第二次查询到缓存中:");
		List<User> users2 = userService.findUsers();
		for (User user : users2) {
			System.out.println(user.getUsername());
		}
	}
	
	@Test
	public void findAll2() {
		
		System.out.println("第一次查询:");
		List<User> users = userService.findUsers();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		
		
		User user = new User();
		user.setId(2L);
		user.setUsername("张三w3w");
		userService.update(user);
		
		
		System.out.println("第二次查询到缓存中:");
		List<User> users2 = userService.findUsers();
		for (User user2 : users2) {
			System.out.println(user2.getUsername());
		}
	}
	
	
	@Test
	public void deleteUser() {
		
		System.out.println("第一次查询:");
		List<User> users = userService.findUsers();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		
		userService.deleteUser(2L);
		
		System.out.println("第二次查询到缓存中:");
		List<User> users2 = userService.findUsers();
		for (User user2 : users2) {
			System.out.println(user2.getUsername());
		}
	}
	
	
	@Test
	public void getUser() {
		System.out.println("第一次查询:");
		Optional<User> user = userService.getUser(1L);
		System.out.println(user.get().getUsername());
		System.out.println("第二次查询到缓存中:");
		Optional<User> user2 = userService.getUser(1L);
		System.out.println(user2.get().getUsername());
	}
	
	@Test
	public void findUsers2() {
		System.out.println("第一次查询:");
		User params = new User();
		params.setUsername("徐柯");
		List<User> users = userService.findUsers(params);
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		
		System.out.println("第二次查询到缓存中:");
		List<User> users2 = userService.findUsers(params);
		for (User user2 : users2) {
			System.out.println(user2.getUsername());
		}
	}
}
