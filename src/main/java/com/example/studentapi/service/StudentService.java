package com.example.studentapi.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentapi.data.StudentRepository;
import com.example.studentapi.model.Student;

// @Component // This is fine.
@Service // This is better more specific 
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public List<Student> getStudents() {



		return studentRepository.findAll();  // Dynamic from model.repo.access_layer.


		// return List.of( // Static list.
		// 	new Student(1L, "Mariam","foo@hotmail.com",
		// 		LocalDate.of(2000, Month.JANUARY, 1)
		// 	)
		// );
	}

	public void addNewStudent(Student student) {
		// Business logic before saving,Like regex, other validation 
		Optional<Student> stu = studentRepository.findStudentByEmail(student.getEmail());
		if (stu.isPresent()) 
			throw new IllegalStateException("Email taken");
			// As Prof says, create custom exception

		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		if (!studentRepository.existsById(studentId)) {
			throw new IllegalStateException(
				"Student id with: " + studentId + " doesn't exist"
			);
		}
		studentRepository.deleteById(studentId);



	}
	
}
