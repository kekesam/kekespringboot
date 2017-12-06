package com.mk.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mk.bean.User;


@Controller
public class RestClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ResponseBody
	@GetMapping("/client/{id}")
	public User template2(@PathVariable("id")Integer id){
		String uri = "http://localhost:8089/service/{id}";
		return restTemplate.getForObject(uri,User.class, id);
	}
	
	
	@ResponseBody
	@GetMapping("/client2/{id}")
	public HashMap<String, Object> template3(@PathVariable("id")Integer id,HttpServletRequest request){
		String uri = "http://localhost:8089/service2/{id}";
		//return restTemplate.postForObject(uri,request,HashMap.class, id);
		return restTemplate.getForObject(uri,HashMap.class, id);
	}
}
