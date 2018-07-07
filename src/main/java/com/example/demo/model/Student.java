package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_name")
	private String student_name;
	
	@Column(name="student_year")
	private int year;
	
	@Column(name="hours")
	private int hours;
	
	@Column(name="major")
	private String major;

	@ManyToOne
	private Course course;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String student_name, int year, int hours, String major, int courseId) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.year = year;
		this.hours = hours;
		this.major = major;
		this.course = new Course(courseId , "" , 0,0);
	}


	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getStudent_name() {
		return student_name;
	}



	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", student_name=" + student_name + ", year=" + year + ", hours=" + hours
				+ ", major=" + major + "]";
	}
	
	
	
}