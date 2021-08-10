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

//	@ManyToOne //employee pode ter várias roles
//	@JoinColumn(name = "role_id")
//	private Role role;
//	@ManyToOne
//	@JoinColumn(name = "band_id")
//	private Band band;

	
	public Employee() {}

	public Employee(Long id, String name, String gender, String petName, Integer age, String band, String job, User user) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.petName = petName;
		this.age = age;
		this.band = band;
		this.job = job;
		this.user = user;
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
