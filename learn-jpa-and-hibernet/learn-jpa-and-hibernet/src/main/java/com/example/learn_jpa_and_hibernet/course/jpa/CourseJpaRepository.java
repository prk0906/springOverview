package com.example.learn_jpa_and_hibernet.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.learn_jpa_and_hibernet.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course c = entityManager.find(Course.class, id);
		entityManager.remove(c);
	}
}
