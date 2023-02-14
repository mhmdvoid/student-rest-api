package com.example.studentapi.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.studentapi.data.StudentRepository;
import com.example.studentapi.model.Student;

@Configuration
public class StudentConfig { // To create beans 
	// Which's object creation, managed by Spring API.

	@Bean
	CommandLineRunner commandLineRunner(
	StudentRepository repo/*To access it, Like a client*/) {
		return args -> {
			var khalid = new Student("Khalid", "kha@gmail.com",
											LocalDate.of(2000, 2, 24)
									);
			var mohammed = new Student("Mohammed", "m7u@gmail.com",
											LocalDate.now()
									);
			repo.saveAll(List.of(khalid, mohammed));
		};
	}
}
