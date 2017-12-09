package com.mk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mk.bean.Course;

import net.sf.ehcache.CacheManager;

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
	@CacheEvict(value=COURSE_CACHE_NAME,key="'course_cache_findCoursesPage'")
	public boolean delete(Long id) {
		try {
			courseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
