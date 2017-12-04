package com.mk.web;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.Special;

import lombok.extern.log4j.Log4j;

@Controller
//@Slf4j
@Log4j
public class LogController {

	private Logger logger = Logger.getLogger(LogController.class);
	
	@RequestMapping("/index")
	public String index() {
		log.debug("进入首页了...........");
		logger.debug("进入首页了吗.............");
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/specail")
	public Special json() {
		Special special = new Special();
		special.setId("1");
		special.setCreatetime(new Date().getTime());
		special.setImg("aaa.jpg");
		special.setStatus(1);
		special.setTitle("我是标题");
		return special;
	}
}
