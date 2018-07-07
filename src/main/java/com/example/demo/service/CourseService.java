package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {

	final static Logger logger = Logger.getLogger(CourseService.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = null;
		try {
			courses = (List<Course>)(courseRepository.findAll());
			if (courses == null) {
				throw new NullPointerException("courses == null");
			}else {
				logger.info("getAllCourses() executed successfully, "+courses.size()+" Courses were returned");
			}

		}catch (NullPointerException e) {
			logger.error("No courses in the database :>"+e.getMessage());
		} 	
		catch (Exception e) {
			logger.error("Failed to query the database with findAll()");
		}
		return courses;

	}
	
	public Course getCourseById(int id) {
		Course course = null;
		try {
			course = courseRepository.findById(id).get();
			logger.info("findById("+id+") executed successfully, returned: " +course.toString());
		} catch (Exception e) {
			logger.error("Failed to query the database with findById("+id+") "+e.getMessage());
		}
		return course;
	}
	
	public Course saveCourse(Course course) {
		Course Retcourse = null;
		try {
			if (!courseRepository.equals(course)) {
				Retcourse = courseRepository.save(course);
				logger.info("Save("+course.toString()+") was succesful");
			}else {
				logger.info("Failed Save("+course.toString()+"), Course already exists");
			}
		} catch (Exception e) {
			logger.error("Failed to query the database with save("+course.toString()+") "+e.getMessage());
		}
		return Retcourse;
	}
	
	public boolean  updateCourse(int id , Course course) {
		boolean success = false;
		
		if(courseRepository.existsById(id)) {
			if(courseRepository.save(course) != null) {
				logger.info("update("+course.toString()+") was successful");
				success = true;
			}else {
				logger.error("Failed to query the database with update("+course.toString()+") Failed to Update");
			}
		}else {
			logger.error("Failed to query the database with update("+course.toString()+"), Course Doesnt Exists");
		}
		return success;
	}
	
	
	public boolean deleteCourse(int id) {
		boolean success = false;
		if(courseRepository.existsById(id)) {
			try {
				courseRepository.deleteById(id);
				success = true;
				logger.info("deleteById("+id+") was successful");
			} catch (Exception e) {
				logger.error("Failed to query the database with deleteById("+id+"), "+e.getMessage());
			}
		}else {
			logger.error("Failed to query the database with deleteById("+id+"), Course doesnt exists");
		}
		return success;
	}

}