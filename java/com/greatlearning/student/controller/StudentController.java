package com.greatlearning.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;
import com.greatlearning.student.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		//get  students from db
		
		List<Student> theStudents = studentService.findAll();
		
		//add to the spring model
		theModel.addAttribute(theStudents);
		return "list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel) {
		//create model attribute to bind form data
		
		Student theStudent = new Student();
		
		theModel.addAttribute("Student",theStudent);
		return "Student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId , Model themodel) {
		
		Student theStudent = studentService.findById(theId);
		
		themodel.addAttribute("Student", theStudent);
		return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, 
			@RequestParam("department") String department, @RequestParam("country") String country){
		
		System.out.println(id);
		Student theStudent;
		if(id!=0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else 
			theStudent = new Student(firstName, lastName, department, country);
			
			studentService.save(theStudent);
			
			return "redirect:/student/list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		studentService.deleteById(theId);
		
		return "redirect:/student/list";
	}
}
