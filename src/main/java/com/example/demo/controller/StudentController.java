package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.studentService;

@RestController
public class StudentController {

	final static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private studentService studentService;
	
	@RequestMapping(value="/course/{courseId}/students")
	public List<Student> getAllStudents(@PathVariable int courseId){
		logger.info("Entered getAllStudents("+courseId+")  URI:/course/{courseId}/students Method:GET");
		return studentService.getAllStudents(courseId);
	}
	
	@RequestMapping(value="/students")
	public List<Student> getAll(){
		logger.info("Entered getAll()  URI:/students Method:GET");
		return studentService.getAll();
	}
	
	@RequestMapping(value="/course/{courseId}/students/{id}")
	public Student getStudentById(@PathVariable int id ) {
		logger.info("Entered getStudentById("+id+")  URI:/course/{courseId}/students/{id} Method:GET");
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value = "/course/{courseId}/students")
	public Student saveStudent(@RequestBody Student student , @PathVariable int courseId) {
		logger.info("Entered saveStudent("+student.toString()+" , "+courseId+")  URI:/course/{courseId}/students Method:POST");
		student.setCourse(new Course(courseId, "" , 0 , 0));
		return studentService.saveStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/course/{courseId}/students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable int courseId) {
		logger.info("Entered updateStudent("+student.toString()+" , "+courseId+")  URI:/course/{courseId}/students/{id} Method:PUT");
		student.setCourse(new Course(courseId, "" , 0 , 0));
		studentService.updateStudent(student.getId(), student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/course/{courseId}/students/{id}")
	public void deleteStudent(@PathVariable int id ) {
		logger.info("Entered deleteStudent("+id+")  URI:/course/{courseId}/students/{id} Method:DELETE");
		studentService.deleteStudent(id);
	}
}