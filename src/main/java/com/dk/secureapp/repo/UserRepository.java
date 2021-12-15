package com.dk.secureapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.secureapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByusername(String username);

}
