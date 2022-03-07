package com.soap.webservices.soapcoursemanagement.soap.bean;

public class Course {
	private int id;
	private String name;
	private String description;
	
	public Course(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void seName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s, description=%s]", id, name, description);
	}
	
	
}
