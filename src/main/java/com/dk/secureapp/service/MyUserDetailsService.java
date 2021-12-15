package com.dk.secureapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dk.secureapp.model.User;
import com.dk.secureapp.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user  = repo.findByusername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found!!!!");
		}
		
		return new UserPrincipal(user);
	}

}
