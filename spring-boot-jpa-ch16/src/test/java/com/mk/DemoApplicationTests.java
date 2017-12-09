package com.mk;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.mk.bean.Course;
import com.mk.dao.CourseService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	private CourseService courseService;

	@Test
	public void getCourse() {
		System.out.println("=================>"+cacheManager);
		/*Cache cache = cacheManager.getCache("");*/
		//cacheManager.addCache(cache);
		List<Course> courses = courseService.findCourses();
		System.out.println("第一次查询：" + courses.size());  
		List<Course> courses2 = courseService.findCourses();
		System.out.println("第二次查询：" + courses2.size());  
	}
	
	@Test
	public void pageCourse() {
		Page<Course> courses = courseService.findCoursesPage(1, 1);
		System.out.println("第一次查询：" + courses.getContent().size());  
		Page<Course> courses2 = courseService.findCoursesPage(1, 1);
		System.out.println("第二次查询：" + courses2.getContent().size());  
	}

	
}
