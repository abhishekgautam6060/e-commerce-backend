package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.controller.model.User;
import com.ecommerce.exception.UserException;
import com.ecommerce.jwt.JwtAuthenticationFilter;
import com.ecommerce.repo.UserRepository;




@Service
public class UserServiceImplementation implements UserService{
	
	
	private UserRepository userRepository;
		
	private JwtAuthenticationFilter jwtAuthenticationFilter;
		
	private PasswordEncoder passwordEncoder;
	
	
	  public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder ,JwtAuthenticationFilter jwtAuthenticationFilter) {	  
		  this.userRepository=userRepository; 
		  this.passwordEncoder=passwordEncoder;	 
		  this.jwtAuthenticationFilter=jwtAuthenticationFilter;
	 }
	
	@Override
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
		
	@Override
	public User findUserById(Long userId) throws UserException {
		Optional<User> user=userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException("user not found with id:" + userId);
	}
	
	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
				
		String email=jwtAuthenticationFilter.username;		
		
		User user= userRepository.findByEmail(email);
		if(user==null) {
			throw new UserException("user not found with email");
		}				
		return user;
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User createdUser= userRepository.save(user);
		
		
		
		return userRepository.save(user);
	}

}
