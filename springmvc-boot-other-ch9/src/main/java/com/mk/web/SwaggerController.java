package com.mk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SwaggerController {
	

	@GetMapping("/swgger/index")
	public String index(){
		return "swgger/index";
	}
	
}
