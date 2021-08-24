package com.wipro.rp.skillmng.data;

import com.wipro.rp.skillmng.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.User;

import java.util.Optional;

public interface UserRepository 
	extends CrudRepository<User, Long>{
	User findUserByUsername(String username);
	Optional<User> findEmployeeByUsername(String username);



}
