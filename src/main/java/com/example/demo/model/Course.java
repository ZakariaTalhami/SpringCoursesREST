package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_name")
	private String course_name;
	
	@Column(name="course_year")
	private int year;
	
	@Column(name="hours")
	private int hours;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(int id, String course_name, int year, int hours) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.year = year;
		this.hours = hours;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", year=" + year + ", hours=" + hours + "]";
	}

	
}