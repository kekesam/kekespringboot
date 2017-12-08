package com.mk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestMappingController {


	@RequestMapping("handler")
	public String handler1() {
		return "index";
	}
	
	@RequestMapping(value="/handler2")
	public String handler2() {
		return "index";
	}
	
	
	@RequestMapping(value="/handler3",method=RequestMethod.GET)
	public String handler3() {
		return "index";
	}
	
	
	@RequestMapping(value="/handler4",method=RequestMethod.POST)
	public String handler4() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/handler5",consumes="application/json")
	public String handler5() {
		System.out.println("进来了....");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/handler6",produces="application/json")
	public String handler6() {
		return "index";
	}
	
	@RequestMapping(value="/handler7",params="id")
	public String handler7() {
		return "index";
	}
	
	@RequestMapping(value="/handler8",params="id=1")
	public String handler8() {
		return "index";
	}
	
	@GetMapping("/reg2")
	public String reg2() {
		return "reg";
	}
	
	@PostMapping("/reg3")
	public String reg3() {
		return "reg";
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
}
