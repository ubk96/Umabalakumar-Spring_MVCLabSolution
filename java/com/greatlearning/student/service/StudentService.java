package com.greatlearning.student.service;

import java.util.List;

import javax.transaction.Transactional;

import com.greatlearning.student.entity.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(int id);

	void save(Student theStudent);

	void deleteById(int theId);

}