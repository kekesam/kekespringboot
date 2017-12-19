package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController2 {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping("/redis")
	@ResponseBody
	public String redis() {
		redisTemplate.opsForList().leftPush("keke:list", "张三");
		redisTemplate.opsForList().rightPushIfPresent("keke:list", "张三");
		return redisTemplate.opsForValue().get("username");
	}
}
