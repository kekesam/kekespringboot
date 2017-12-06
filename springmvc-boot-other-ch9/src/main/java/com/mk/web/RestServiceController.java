package com.mk.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class RestServiceController {
	
	@Autowired
	private RestTemplate restTemplate;

	@ResponseBody
	@PostMapping("/client/{id}")
	public HashMap<String, Object> template(@PathVariable("id")Integer id){
		String uri = "http://www.mengkedu.com/ssmmybatis3/data/{id}";
		return restTemplate.getForObject(uri, HashMap.class, id);
	}
	
	
	@ResponseBody
	@PostMapping("/client2/{id}")
	public HashMap<String, Object> template2(@PathVariable("id")Integer id){
		String uri = "http://localhost/ssmmybatis3/data2/{id}";
		return restTemplate.postForObject(uri,null, HashMap.class, id);
	}
}
