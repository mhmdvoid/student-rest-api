package com.example.studentapi.model;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity // Hibernate to create a table.
@Table // for our table in database.
// Every model gets mapped to a our database table.
public class Student {

	@Id
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	private long id;
	private String name, email;
	private LocalDate dob;

	@Transient // This field, no need to be column.
	// Leave it in memory.
	private Integer age;

	public Student() {}

	public Student(long id, String name, String email, LocalDate date) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = date;
	}

	public Student(String name, String email, LocalDate date) {
		this.name = name;
		this.email = email;
		this.dob = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return name + ", Email: " + email;
	}


}
