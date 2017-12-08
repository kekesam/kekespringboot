package com.mengke;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mengke.bean.TmParams;
import com.mengke.bean.User;
import com.mengke.mapper.IUserMapper;
import com.mengke.util.MD5PwdUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootFreemakerApplicationTests {
	
	@Autowired
	private IUserMapper userMapper;
	

	@Test
	public void findUsers() {
		TmParams params = new TmParams();
		params.setPageNo(0);
		params.setPageSize(5);
		List<User> users = userMapper.findUsers(params);
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}
	
	@Test
	public void loginTest(){
		User user = userMapper.getLogin("keke", "1245678");
		if(user!=null){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	
	@Test
	public void pwdMd5(){
		System.out.println(MD5PwdUtil.md5Base64("123456"));
	}
	
	@Test
	public void delUser(){
		int count=userMapper.deluser("20 or 1=1");
		System.out.println(count);
	}
	
}
