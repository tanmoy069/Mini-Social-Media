package com.tanmoy.brainstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.brainstation.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUserId(String userId);
	User findByEmail(String email);
}
