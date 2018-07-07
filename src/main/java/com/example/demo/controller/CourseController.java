package com.example.demo.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	final static Logger logger = Logger.getLogger(CourseController.class);
	
	@RequestMapping(value="/course")
	public List<Course> getAllCourses(){
		logger.info("Entered getAllCourses()  URI:/course Method:GET");
		return courseService.getAllCourses();
	}
	
	@RequestMapping(value="/course/{id}")
	public Course getCourseById(@PathVariable int id ) {
		logger.info("Entered getCourseById("+id+")  URI:/course/{id} Method:GET");
		return courseService.getCourseById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value = "/course")
	public Course saveCourse(@RequestBody Course course) {
		logger.info("Entered saveCourse("+course.toString()+")  URI:/course Method:POST");
		return courseService.saveCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/course")
	public void updateCourse(@RequestBody Course course) {
		logger.info("Entered updateCourse("+course.toString()+")  URI:/course Method:PUT");
		courseService.updateCourse(course.getId(), course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/course/{id}")
	public void deleteCourse(@PathVariable int id ) {
		logger.info("Entered deleteCourse("+id+")  URI:/course/{id} Method:DELETE");
		courseService.deleteCourse(id);
	}
}