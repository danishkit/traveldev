package com.example.travelprojectregistration.service;

import java.util.List;

import com.example.travelprojectregistration.entity.User;

public interface UserService {
	
	//Registration Page
	
	//Method to save the user
	User registerUser(User user);
	
	//Method to fetch the user details
	List<User> getAllUsers();
	
	//Update user
	User updateUser(User user, long id);
		
	// Delete user
	void deleteUser(long id);
	}
