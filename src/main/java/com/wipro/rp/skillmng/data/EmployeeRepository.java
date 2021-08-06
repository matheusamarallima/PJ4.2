package com.wipro.rp.skillmng.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.Employee;

public interface EmployeeRepository 
	extends CrudRepository<Employee, String>{
	public List<Employee> findAllByOrderByName();
	public Employee findByUserUsernameAndPetName(String username, String petName);
}
