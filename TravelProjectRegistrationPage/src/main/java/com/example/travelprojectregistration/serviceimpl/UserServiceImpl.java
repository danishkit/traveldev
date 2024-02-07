package com.example.travelprojectregistration.serviceimpl;


import java.util.List;

import org.springframework.stereotype.Service;
import com.example.travelprojectregistration.exception.*;
import com.example.travelprojectregistration.entity.User;
import com.example.travelprojectregistration.repository.UserRepository;
import com.example.travelprojectregistration.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//Registration Page
	//Save the user details
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
		
	}
	
    //Get the user details
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//Update User details
	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", id));
		
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setMobileNo(user.getMobileNo());
		existingUser.setPassword(user.getPassword());
		
		
		//save existing user to DB
		userRepository.save(existingUser);
		return existingUser;
		
	}

	//Delete user
	@Override
	public void deleteUser(long id) {
		//check whether the user exist in the DB
				userRepository.findById(id).orElseThrow(() -> 
				                          new ResourceNotFoundException("User", "id", id));
				userRepository.deleteById(id);
			}
		
		
	}

	

	
	
	