package com.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {
	
	public enum Status{
		SUCCESS, FAILURE;
	}
	
	private static List<Course> courseList = new ArrayList<>();
	
	
	
	static {
		
		Course course1 = new Course(1, "MicroServices", "This gives Detailed info about MicroServices");
		courseList.add(course1);
		
		Course course2 = new Course(2, "JSP", "This gives Detailed info about JSP");
		courseList.add(course2);
		
		Course course3 = new Course(3, "LeetCode", "This gives Detailed info about LeetCode");
		courseList.add(course3);
		
		Course course4 = new Course(4, "Dynamic Programming", "This gives Detailed info about Dynamic Programming");
		courseList.add(course4);
	}
	
	//get course 1 given ID
	 public Course findById(int Id) {
		 for(Course course:courseList) {
			 if(course.getId() == Id) {
				 return course;
			 }
		 }
		 return null;
	 }
	
	// get all course details
	public List<Course> findAll(){
		return courseList;
	}
	
	//delete course
	public int deleteById(int Id) {
		
		Iterator<Course> iterator = courseList.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == Id) {
				 iterator.remove();
				 return 1;
			 }
		}
		return 0;
	}
	
	//updating course and new course
	
}
