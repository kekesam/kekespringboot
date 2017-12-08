package com.mk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.User;
import com.mk.dao.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmvcBootCh4ApplicationTests {

	@Autowired
	private IUserDao userDao;
	
	@Test
	public void findUsers() {
		List<User> users = userDao.findUsers();
		assertNotNull("测试当前集合不为null",users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveUser() {
		User user = new User();
		user.setUsername("徐柯");
		user.setAccount("xuke");
		int count = userDao.saveUser(user);
		assertTrue("如果预判的结果不正确，我会打印出来哦!!!说明我报错了",count>0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteUser() {
		User user = userDao.getUser(9);
		assertNotNull("你当前的对象为null",user);
		int count = userDao.deleteUser(9);
		assertTrue("如果预判的结果不正确，我会打印出来哦!!!说明我报错了",count>0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateUser() {
		User user = userDao.getUser(9);
		assertNotNull("你当前的对象为null",user);
		User user2 = new User();
		user2.setUsername("徐柯update");
		user2.setId(9);
		int count = userDao.saveUser(user);
		assertTrue("如果预判的结果不正确，我会打印出来哦!!!说明我报错了",count>0);
	}
}
