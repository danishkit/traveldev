package com.example.travelprojectregistration.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelprojectregistration.entity.User;
import com.example.travelprojectregistration.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registration")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Registration Page
	
	@PostMapping("/save")
	public ResponseEntity<User>saveUser(@Valid @RequestBody User user){
			  
	    return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}
}



    


	


