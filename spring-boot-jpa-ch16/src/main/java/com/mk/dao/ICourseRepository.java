package com.mk.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	//分页查询
	public Page<Course> findByTitleLike(String title,Pageable pageable);

	// 根据标题查询
	public List<Course> findByTitle(String title);

	// 根据标题模糊查询
	public List<Course> findByTitleLike(String title);

	// 根据标题查询并且创建排降序
	public List<Course> findByTitleOrderByCreateTimeDesc(String title);

	// 根据标题查询前10条记录
	public List<Course> findFirst10ByTitle(String title);

	// 根据标题查询前10条记录
	public List<Course> findTop10ByTitle(String title);

	// 根据标题和删除状态And查询
	public List<Course> findByTitleAndIsDelete(String title, Integer isDelete);

	// 根据标题和删除状态用OR查询
	public List<Course> findByTitleOrIsDelete(String title, Integer isDelete);

	// 根据ID查询当个
	public Course getById(Long id);

	// 根据标题和删除状态用OR查询
	public List<Course> queryByTitleOrIsDelete(String title, Integer isDelete);

	@Query("select c from Course c where c.id = ?1")
	Course getCourseById(Long id);

	@Query(value = "select * from mk_course c where c.id = ?1", nativeQuery = true)
	Course getNativeCourseById(Long id);

	@Query("select c from Course c where c.title like  %?1% and c.isDelete=?2")
	List<Course> findCourseByTitle(String title, Boolean isDelete);

	@Query("select c from Course c where c.title like  %:title% and c.isDelete=:isDelete")
	List<Course> findCourseByTitleByNamespace(@Param("title") String title, @Param("isDelete") Boolean isDelete);

	@Modifying
	@Query("update Course c set c.title = ?1 where c.id= ?2")
	@Transactional(readOnly=false)
	int updateCourseTitle(String title, Long id);
	
	
	@Modifying
	@Query("update Course c set c.title =  :#{#course.title} where c.id=  :#{#course.id}")
	@Transactional(readOnly=false)
	int updateCourseTitle(@Param("course")Course course);

	@Modifying
	@Query("delete from Course c where c.id = ?1")
	@Transactional(readOnly=false)
	int deleteCourseById(Long courseId);
	
	@Modifying
	@Query("update Course sc set sc.isDelete = :isDelete where sc.id in :ids")
	public void deleteByIds(@Param(value = "isDelete") Boolean isDelete, @Param(value = "ids") List<Long> ids);

	@Modifying
	@Query("update Course sc set sc.isDelete = :isDelete where sc.id = :id")
	public void deleteById(@Param(value = "isDelete") Boolean isDelete, @Param(value = "id") Long id);
	
	
	@Procedure("MK_COURSE_HITS")
	Integer explicitlyNamedPlus1inout(Integer arg);
}
