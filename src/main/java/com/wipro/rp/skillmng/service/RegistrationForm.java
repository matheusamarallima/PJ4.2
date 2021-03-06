package com.wipro.rp.skillmng.service;

import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Project;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.wipro.rp.skillmng.domain.Employee;
//import com.wipro.rp.skillmng.domain.Gender;
import com.wipro.rp.skillmng.domain.User;

public class RegistrationForm {
	
	private static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
	private String name;
	private String petName;
	private Integer age;
	private String gender;
	private String job;
	private String band;
	private Project project;
	private User user;

	public RegistrationForm() {

	}


	public Employee DTOtoEntity(Employee employee){
		return new Employee(employee.getName(),
				employee.getGender(), employee.getPetName(),
				employee.getAge(), employee.getBand(), employee.getJob(),
				toUser(employee.getUser()),
				employee.getProject());

	}

	public RegistrationForm(String name, String petName, Integer age, String gender, String job, String band, Project project, User user) {
		this.name = name;
		this.petName = petName;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.band = band;
		this.project = project;
		this.user = user;
	}



	public User toUser(User user) {

		return new User(
				user.getUsername(),
				new BCryptPasswordEncoder().encode(String.valueOf(user.getPassword())),
				ROLE_EMPLOYEE);
	}


	public Employee toEmployee(User user) {
		Employee employee = new Employee();
		employee.setUser(user);
		return employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}