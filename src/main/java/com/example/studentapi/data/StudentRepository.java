package com.example.studentapi.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentapi.model.Student;

// Responsible for interacting with db/
// data access layer.
@Repository
public interface StudentRepository 
		extends JpaRepository<Student, Long> {
	// Every meth invoke. is hibrenate maniuplation
}
