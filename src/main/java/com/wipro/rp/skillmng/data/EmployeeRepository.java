package com.wipro.rp.skillmng.data;

import java.util.List;
import java.util.Optional;

import com.wipro.rp.skillmng.domain.User;
import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.Employee;

public interface EmployeeRepository 
	extends CrudRepository<Employee, Long>{
	public List<Employee> findAllByOrderByName();
	public Employee findByUserUsernameAndPetName(String username, String petName);
    Optional<Employee> findByName(String name);

    Employee findByUserUsername(User user);
}
