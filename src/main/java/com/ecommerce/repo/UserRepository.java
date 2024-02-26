package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.controller.model.User;


//public interface UserRepository extends JpaRepository<User, String>{
public interface UserRepository extends JpaRepository<User, Long>{
		
	public User findByEmail(String email);

}
