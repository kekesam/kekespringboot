package com.mk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mk.bean.Course;

@Service
public class CourseService{
	
	//这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'course_cache'";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
    */
    public static final String COURSE_CACHE_NAME = "courses";
	
	@Autowired
	private ICourseRepository courseRepository;
	
	//查询所有的数据
	@Cacheable(value=COURSE_CACHE_NAME,key=CACHE_KEY)
	public List<Course> findCourses(){
		return courseRepository.findAll();
	}
	 
	//查询分页
	@Cacheable(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'")
	public Page<Course> findCoursesPage(int pageNo,int pageSize){
		//根据时间排降序
		Sort sort = new Sort(Direction.DESC,"createTime");
		PageRequest request = PageRequest.of(pageNo-1, pageSize, sort);
		return courseRepository.findAll(request);
	}
	
	//查询分页+模糊搜索
	@Cacheable(value=COURSE_CACHE_NAME,key="'course_cache_findByTitleLike'")
	public Page<Course> findByTitleLike(String title,int pageNo,int pageSize){
		//根据时间排降序
		Sort sort = new Sort(Direction.DESC,"createTime");
		PageRequest request = PageRequest.of(pageNo-1, pageSize, sort);
		return courseRepository.findByTitleLike(title,request);
	}
	
	//查询分页+模糊搜索
	@Cacheable(value=COURSE_CACHE_NAME,key="'course_cache_findByExample'")
	public Page<Course> findByExample(String title,int pageNo,int pageSize){
		//设置查询条件
		Course course = new Course();
		course.setTitle(title);
		//设置匹配规则
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("title", GenericPropertyMatcher.of(StringMatcher.CONTAINING));
		Example<Course> example = Example.of(course,matcher);
		//根据时间排降序
		Sort sort = new Sort(Direction.DESC,"createTime");
		PageRequest request = PageRequest.of(pageNo-1, pageSize, sort);
		return courseRepository.findAll(example,request);
	}
	
	
	public List<Course> findExampleQuery(String title,Boolean isDelete){
		Course course = new Course();
		course.setTitle(title);
		course.setIsDelete(isDelete);
		Example<Course> example = Example.of(course);
		return courseRepository.findAll(example);
	}
	
	//查询单个
	@Cacheable(value=COURSE_CACHE_NAME,key="'course_cache_getcourse'+#id")
	public Course getCourse(Long id) {
		return courseRepository.getOne(id);
	}
	
	//保存
	@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'")
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
	//修改
	@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'")
	public Course update(Course course) {
		return courseRepository.saveAndFlush(course);
	}
	
	
	//根据Id删除
	//@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'")
	@Caching(evict= {@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'"),
			@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage2'")})
	public boolean delete(Long id) {
		try {
			courseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
