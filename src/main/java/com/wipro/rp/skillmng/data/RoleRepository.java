package com.wipro.rp.skillmng.data;

import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.Role;

public interface RoleRepository 
	extends CrudRepository<Role, Long>{
}
