package com.example.studentapi.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.lang.model.element.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentapi.data.StudentRepository;
import com.example.studentapi.model.Student;

import jakarta.transaction.Transactional;

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
				"Student with id: " + studentId + " doesn't exist"
			);
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long id, String n, String em)	 {
		Student st = studentRepository.findById(id)
						.orElseThrow(() -> new IllegalStateException(
							"student with id: " + id + " doesn't exist"
						));

		if (n != null && 
				n.length() > 0 &&
				!Objects.equals(st.getName(), n)) {
			st.setName(n);
		}

		if (em != null && 
				em.length() > 0 &&
				!Objects.equals(st.getEmail(), em)) {
			Optional<Student> optStu = studentRepository
						.findStudentByEmail(em);
			if (optStu.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			st.setEmail(em);
		}
	}
	
}
