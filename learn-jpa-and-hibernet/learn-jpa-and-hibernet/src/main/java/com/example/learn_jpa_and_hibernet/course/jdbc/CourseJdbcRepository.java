package com.example.learn_jpa_and_hibernet.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.learn_jpa_and_hibernet.course.Course;


@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate template;
	
	private String query = 
			"""
				insert into course(id,name,author)
				values(?,?,?)
			""";
	private String delete = 
			"""
				delete from
				course Where id = ?
			""";
	private String select = 
			"""
				Select *
				from course
				where id = ?
			""";
	public void insert(Course course)
	{
		template.update(query,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(long id)
	{
		template.update(delete,id);
	}
	
	public Course findById(long id) {
		return template.queryForObject(select,new BeanPropertyRowMapper<>(Course.class),id);
	}
}
