package com.wipro.rp.skillmng.data;

import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.User;

public interface UserRepository 
	extends CrudRepository<User, Long>{
	public User findUserByUsername(String username);
}
