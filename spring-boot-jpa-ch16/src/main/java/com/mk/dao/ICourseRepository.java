package com.mk.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mk.bean.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	@Modifying
	@Query("update Course sc set sc.isDelete = :isDelete where sc.id in :ids")
	public void deleteByIds(@Param(value = "isDelete") Boolean isDelete,@Param(value = "ids") List<Long> ids);
	
	@Modifying
	@Query("update Course sc set sc.isDelete = :isDelete where sc.id = :id")
	public void deleteById(@Param(value = "isDelete") Boolean isDelete,@Param(value = "id") Long id);
}
