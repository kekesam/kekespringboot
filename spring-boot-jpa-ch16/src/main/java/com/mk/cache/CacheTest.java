package com.mk.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {

	public static void main(String[] args) {
		CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");  
		Cache cache = manager.getCache("courses");  
		cache.put(new Element("username_cache", "xuke"));  
		manager.shutdown();  
	}
}
