package com.mk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.Course;
import com.mk.dao.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//查询
	@RequestMapping("/index")
	public String index(Model model) {
		List<Course> courses = courseService.findCourses();
		model.addAttribute("courses", courses);
		return "index";
	}
	
	//查询分页
	@RequestMapping("/page/{pageNo}/{pageSize}")
	public String page(@PathVariable("pageNo")String pno,
			@PathVariable("pageSize")String psize,Model model) {
		int pageNo = 1;
		int pageSize = 5;
		try {
			pageNo = Integer.parseInt(pno);
			pageSize = Integer.parseInt(psize);
		} catch (Exception e) {
		}
		Page<Course> page = courseService.findCoursesPage(pageNo,pageSize);
		model.addAttribute("page", page);
		return "pageindex";
	}
	
	//添加
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	
	//保存逻辑
	@ResponseBody
	@RequestMapping("/course/save")
	public String save(Course course) {
		courseService.save(course);
		return "success";
	}
	
	//修改
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		Course course = courseService.getCourse(id);
		model.addAttribute("course", course);
		return "edit";
	}
	
	//修改逻辑
	@ResponseBody
	@RequestMapping("/course/update")
	public String update(Course course) {
		courseService.update(course);
		return "success";
	}
	
	//根据ID删除逻辑
	@ResponseBody
	@RequestMapping("/course/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		courseService.delete(id);
		return "success";
	}
	
}
