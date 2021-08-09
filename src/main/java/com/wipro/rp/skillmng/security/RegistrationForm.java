package com.wipro.rp.skillmng.security;

import org.springframework.security.crypto.password.PasswordEncoder;


import com.wipro.rp.skillmng.domain.Employee;
//import com.wipro.rp.skillmng.domain.Gender;
import com.wipro.rp.skillmng.domain.User;

public class RegistrationForm {
	
	private static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE"; 
	
	private String userId;
	private String name;
	private String password;
	private String petName;
	private Integer age;
	private String gender;
	private String job;
	private String band;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(
					userId,
					passwordEncoder.encode(password),
					ROLE_EMPLOYEE);
	}
	
	public Employee toEmployee(User user) {
		Employee employee = new Employee();
		employee.setUser(user);
		return employee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}
}