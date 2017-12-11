package com.mk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.cache.support.SimpleCacheManager;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
	
	CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");  
	Cache cache = manager.getCache("courses");  
	
	@Before
	public void cacheput() {
		System.out.println("放入缓存");
		cache.put(new Element("username_cache", "xuke"));  
	}
	
	
	@Test
	public void cacheget() {
		System.out.println("获取缓存");
		Element element = cache.get("username_cache");
		String value = String.valueOf(element.getObjectValue());
		System.out.println(value);
	}
	
	@Test
	public void removecache() {
		cache.remove("username_cache");
	}
	
	@After
	public void removeGet() {
		System.out.println("缓存删除以后===================>");
		Element element = cache.get("username_cache");
		if(element!=null) {
			String value = String.valueOf(element.getObjectValue());
			System.out.println(value);
		}else {
			System.out.println("缓存已被删除!!!!");
		}
	}
	
	
}
