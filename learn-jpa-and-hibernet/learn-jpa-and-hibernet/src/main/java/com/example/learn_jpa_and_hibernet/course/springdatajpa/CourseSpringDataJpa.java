package com.example.learn_jpa_and_hibernet.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn_jpa_and_hibernet.course.Course;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long>{
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
