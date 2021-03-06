package com.wipro.rp.skillmng.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String gender;
	private String petName;
	private Integer age;
	private String band;
	private String job; //before : "role"
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public Employee() {}

	public Employee(String name, String gender, String petName,
					Integer age, String band, String job, User user, Project project) {
		this.name = name;
		this.gender = gender;
		this.petName = petName;
		this.age = age;
		this.band = band;
		this.job = job;
		this.user = user;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(gender, employee.gender) && Objects.equals(petName, employee.petName) && Objects.equals(age, employee.age) && Objects.equals(band, employee.band) && Objects.equals(job, employee.job) && Objects.equals(user, employee.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, gender, petName, age, band, job, user);
	}
}
