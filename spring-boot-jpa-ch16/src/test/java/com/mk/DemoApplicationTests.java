package com.mk;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.mk.bean.Course;
import com.mk.dao.CourseEntityManagerService;
import com.mk.dao.CourseService;
import com.mk.dao.ICourseRepository;

import net.sf.ehcache.CacheManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	CacheManager cacheManager;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseEntityManagerService courseEntityManagerService;
	@Autowired
	private ICourseRepository courseRepository;

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

	
	@Test
	public void getCourseById() {
		//基于JPQL查询
		Course course = courseRepository.getCourseById(1L);
		//基于原生SQL查询
		Course course2 = courseRepository.getNativeCourseById(1L);
		System.out.println(course.getTitle());
		System.out.println(course2.getTitle());
	}
	
	@Test
	public void findCourseByTitle() {
		System.out.println("**************************************");
		List<Course> courses = courseRepository.findCourseByTitle("42", false);
		List<Course> courses2 = courseRepository.findCourseByTitleByNamespace("42", false);
		for (Course course3 : courses) {
			System.out.println(course3.getTitle());
		}
		for (Course course3 : courses2) {
			System.out.println(course3.getTitle());
		}
	}
	
	
	@Test
	public void updateCourse() {
		System.out.println("**************************************");
		int count = courseRepository.updateCourseTitle("Javascript面相对象", 1L);
		System.out.println(count);
	}
	
	@Test
	public void deleteCourse() {
		System.out.println("**************************************");
		int count = courseRepository.deleteCourseById(7L);
		System.out.println(count);
	}

	
	@Test
	public void testProcedure() {
		System.out.println("**************************************");
		int count = courseRepository.explicitlyNamedPlus1inout(100);
		System.out.println(count);
	}
	
	@Test
	public void findCourses() {
		List<Course> courses = courseEntityManagerService.findCourses();
		for (Course course : courses) {
			System.out.println(course.getTitle());
		}
	}
	
	@Test
	public void findCoursesLike() {
		List<Course> courses = courseEntityManagerService.findCourses("%42%",0,2);
		for (Course course : courses) {
			System.out.println(course.getTitle());
		}
	}
	
	@Test
	public void findByExample() {
		Page<Course> courses = courseService.findByExample("42",1,2);
		for (Course course : courses.getContent()) {
			System.out.println(course.getTitle());
		}
	}
	
	@Test
	public void findByTitleLike() {
		Page<Course> courses = courseService.findByTitleLike("%42%",1,2);
		for (Course course : courses.getContent()) {
			System.out.println(course.getTitle());
		}
	}
	
	
	@Test
	public void updateCourses() {
		Course course = new Course();
		course.setId(1L);
		course.setTitle("zhangsadsfasdf");
		courseRepository.updateCourseTitle(course);
	}
	
}
