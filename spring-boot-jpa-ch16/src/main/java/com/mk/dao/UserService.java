package com.mk.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mk.bean.User;

@Service
public class UserService {

	@Autowired
	private IUserRespository userRespository;

	// 定义缓存策略
	public static final String COURSE_CACHE_NAME = "users";

	// 一般用于查询缓存中
	@Cacheable(value = COURSE_CACHE_NAME, key = "'cache_course_findUsers'")
	public List<User> findUsers() {
		System.out.println("来执行方法了.................");
		return userRespository.findAll();
	}

	@Cacheable(value = COURSE_CACHE_NAME, key = "'findUsers'+(#user.username)")
	public List<User> findUsers(User user) {
		return userRespository.findByUsername(user.getUsername());
	}

	@Cacheable(value = COURSE_CACHE_NAME, key = "'getUser'+#id")
	// @Cacheable(value=COURSE_CACHE_NAME,condition="#id>1")
	// @Cacheable(value=COURSE_CACHE_NAME,condition="#id==1")
	public Optional<User> getUser(Long id) {
		return userRespository.findById(id);
	}

	// 一般用户更新缓存的操作使用,更新那个缓存的信息
	@CachePut(value = COURSE_CACHE_NAME, key = "#user.id")
	public void update(User user) {
		System.out.println("来执行方法了.................");
		userRespository.saveAndFlush(user);
	}

	@CacheEvict(value = COURSE_CACHE_NAME, key = "'cache_course_findUsers'")
	public void deleteUser(Long id) {
		userRespository.deleteById(id);
	}

	// 清空单个
	@CacheEvict(value = COURSE_CACHE_NAME, allEntries = true)
	public void deleteAllCache() {

	}

	// 清空多个
	@CacheEvict(cacheNames = { COURSE_CACHE_NAME }, allEntries = true)
	public void deleteAllCaches() {

	}

}
