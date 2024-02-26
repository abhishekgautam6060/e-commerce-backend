package com.ecommerce.service;

import java.util.List;

import com.ecommerce.controller.model.User;
import com.ecommerce.exception.UserException;


public interface UserService {
	
	public List<User> getUsers();
	
	public User createUser(User user);
	
	public User findUserById(Long userId)throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException ;

}
