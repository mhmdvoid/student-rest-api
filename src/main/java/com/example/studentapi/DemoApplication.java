package com.example.studentapi;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentapi.model.Student;

@SpringBootApplication
@RestController // Serve as restful endpoints
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Creating first restful endpoint.

	@GetMapping("/") // only one end point so far
	public List<Student> hello() {
		return List.of(new Student(10l, "Mohammed", "Rashid", LocalDate.of(2000, 2, 24)),
					new Student(10l, "Ahmed", "waleed", LocalDate.of(2002, 6, 18)));

	}

}
