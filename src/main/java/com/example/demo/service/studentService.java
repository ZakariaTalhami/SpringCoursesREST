package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepoitory;
import com.example.demo.repository.StudentRepoitory;

@Service
public class studentService {

	final static Logger logger = Logger.getLogger(studentService.class);
	
	@Autowired
	private StudentRepoitory studentRepository;
	
	public List<Student> getAllStudents(int courseId) {
		List<Student> students=null;
		try {
			students=(List<Student>)(studentRepository.findByCourseId(courseId));
			logger.info("getAllStudents("+courseId+") was successful, "+students.size()+" Studensts were returned");
			logger.debug(students.toString());
		} catch (Exception e) {
			logger.error("Failed to query database getAllStudents("+courseId+"), "+e.getMessage());
			logger.trace(e.getStackTrace().toString());
		}
		return students;

	}
	
	public List<Student> getAll(){
		List<Student> students = null;
		students = (List<Student>)studentRepository.findAll();
		logger.info("getAll() executed successfully, "+students.size()+" Students were returned");
		logger.debug(students.toString());
		return students;
	}
	
	public Student getStudentById(int id) {
		Student student = null;
		try {
			student = studentRepository.findById(id).get();
			logger.info("getStudentById("+id+") executed successfully, student: "+student.toString());
		} catch (Exception e) {
			logger.error("Failed to query database getStudentById("+id+"), "+e.getMessage());
			logger.trace(e.getStackTrace());
		}
		return student;
	}
	
	public Student saveStudent(Student student) {
		Student RetStudent = null;
		try {
			if (!studentRepository.equals(student)) {
				RetStudent = studentRepository.save(student);
				logger.info("Save("+student.toString()+") was succesful");
			}else {
				logger.info("Failed Save("+student.toString()+"), Student already exists");
			}
		} catch (Exception e) {
			logger.error("Failed to query the database with save("+student.toString()+") "+e.getMessage());
		}
		return RetStudent;
	}
	
	public boolean  updateStudent(int id , Student student) {
		boolean success = false;
		
		if(studentRepository.existsById(id)) {
			if(studentRepository.save(student) != null) {
				logger.info("update("+student.toString()+") was successful");
				success = true;
			}else {
				logger.error("Failed to query the database with update("+student.toString()+") Failed to Update");
			}
		}else {
			logger.error("Failed to query the database with update("+student.toString()+"), Student Doesnt Exists");
		}
		return success;
	}
	
	
	public boolean deleteStudent(int id) {
		boolean success = false;
		if(studentRepository.existsById(id)) {
			try {
				studentRepository.deleteById(id);
				success = true;
				logger.info("deleteById("+id+") was successful");
			} catch (Exception e) {
				logger.error("Failed to query the database with deleteById("+id+"), "+e.getMessage());
			}
		}else {
			logger.error("Failed to query the database with deleteById("+id+"), Student doesnt exists");
		}
		return success;
	}

}