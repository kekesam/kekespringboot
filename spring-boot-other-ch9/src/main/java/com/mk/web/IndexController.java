package com.mk.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@PostMapping("/ajax")
	public String test() {
		return "success";
	}
}
