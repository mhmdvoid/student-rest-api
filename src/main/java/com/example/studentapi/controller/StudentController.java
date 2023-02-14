package com.example.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;

@RestController // Serve as endpoints controller.
@RequestMapping("api/v1/student")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
// Web classes most time dependent on services;
	@GetMapping/*("/students")*/ // Specific mapping 'api/v1/student/students'
	public List<Student> allStudents() {
		return studentService.getStudents(); // For now
	}

	@PostMapping
	public void signupStudent(@RequestBody/*
		Parse the payload from req body into jvm object
	*/ Student student) {
		studentService.addNewStudent(student);
	}
	
}
