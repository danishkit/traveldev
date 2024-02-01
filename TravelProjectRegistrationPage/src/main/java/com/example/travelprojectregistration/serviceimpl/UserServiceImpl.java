package com.example.travelprojectregistration.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
		
	}
}
