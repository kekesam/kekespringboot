package com.mk.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class RestClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//访问地址，参数，返回值类型,请求方式
	@ResponseBody
	@RequestMapping("/findspecail/{id}")
	public HashMap<String, Object> findSpecail(@PathVariable("id")Integer id){
		String url = "http://localhost:8080/ssmmybatis3/service/data/{id}";
		return restTemplate.getForObject(url,HashMap.class,id,3);
	}
}
