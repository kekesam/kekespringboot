package com.mk.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestClientController {

	@Autowired
	private RestTemplate template;
	
	
	@GetMapping("/client/data/{id}")
	public HashMap<String, Object> gettemplate(@PathVariable("id")Integer id){
		String url = "http://localhost:8080/ssmmybatis3/service/data/{id}";
		return template.postForObject(url,null,HashMap.class, id);
	}
	
	
	
}






