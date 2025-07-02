package com.example.learn_jpa_and_hibernet.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.learn_jpa_and_hibernet.course.Course;
import com.example.learn_jpa_and_hibernet.course.jdbc.CourseJdbcRepository;
import com.example.learn_jpa_and_hibernet.course.jpa.CourseJpaRepository;
import com.example.learn_jpa_and_hibernet.course.springdatajpa.CourseSpringDataJpa;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository; 
	
	@Autowired
	private CourseSpringDataJpa repository; 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1,"JAVA","X"));
		repository.save(new Course(2,"JAVAe","y"));
		repository.save(new Course(3,"JAVAw","z"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("z"));
		System.out.println(repository.findByName("JAVAe"));
	}

}
