package com.wipro.rp.skillmng.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.User;

@Service
public class UserRepositoryUserDetailsService 
	implements UserDetailsService {

	private UserRepository userRepo;
	
	public UserRepositoryUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUsername(username);
		if(user != null) {
			return user;
		}
		throw new UsernameNotFoundException(
				"User '" + username + "' not found!");
	}

}
