package com.mk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.bean.Course;

@Service
@Transactional
public class CourseEntityManagerService{
	
	@Autowired
	private EntityManager entityManager;
	
	
	public List<Course> findCourses(){
		String qlString = "from Course c";
		return entityManager.createQuery(qlString).getResultList();
	}
	
	
	public List<Course> findCourses(String title,int pageNo,int pageSize){
		String qlString = "from Course c where c.title like :title";
		Query query = entityManager.createQuery(qlString).setFirstResult(pageNo*pageSize).setMaxResults(pageSize);
		query.setParameter("title",title);
		return query.getResultList();
	}
	
}
