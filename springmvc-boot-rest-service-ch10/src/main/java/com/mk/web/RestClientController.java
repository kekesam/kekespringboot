package com.mk.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestClientController {

	@Autowired
	private RestTemplate restTemplate;
	@ResponseBody
	@GetMapping("/client/{id}")
	public HashMap<String, Object> template2(@PathVariable("id")Integer id){
		String uri = "http://localhost:8080/ssmmybatis3/data/{id}";
		return restTemplate.postForObject(uri,null,HashMap.class, id);
	}
}
