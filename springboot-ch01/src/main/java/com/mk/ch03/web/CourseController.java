package com.mk.ch03.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.ch03.service.CourseServiceImpl;

@Controller
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;
	private final Log logger = LogFactory.getLog(getClass());
	
	@ResponseBody
	@RequestMapping("/course")
	public String test() {
		logger.debug("====[课程保存日志管理]");
		return courseService.save("SpringBoot课程");
	}
}
