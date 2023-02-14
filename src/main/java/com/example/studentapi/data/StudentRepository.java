package com.example.studentapi.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.studentapi.model.Student;

// Responsible for interacting with db/
// data access layer.
@Repository
public interface StudentRepository 
		extends JpaRepository<Student, Long> {


	// Every meth invoke. is hibrenate maniuplation




			// I can comment
	@Query("SELECT s FROM Student s WHERE s.email = ?1")
	Optional<Student> findStudentByEmail(String email);
			//// custome query;
			// here;

			// things like findByEmail, findBy
			

}
