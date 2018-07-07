package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepoitory extends CrudRepository<Student, Integer> {

	public List<Student> findByCourseId(int courseId);
}