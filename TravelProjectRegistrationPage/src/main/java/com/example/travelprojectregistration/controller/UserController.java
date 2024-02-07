package com.example.travelprojectregistration.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelprojectregistration.entity.User;
import com.example.travelprojectregistration.service.UserService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/registration")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Registration Page
	
	// Save the user details
	@PostMapping("/save")
	public ResponseEntity<User>saveUser(@Valid @RequestBody User user){
		System.out.println("Front end data is fetched" + user); 
			  
	    return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}
	
	//Fetch the user details
	//Get all Users
		@GetMapping("/get")
		public List<User> getAllUsers(){
			return userService.getAllUsers();
		}
	
	//Update the user details
		//Update User
		@PutMapping("/{id}")
		public ResponseEntity<User> updateUser(@PathVariable("id") long userId
				                              ,@RequestBody User user){
			
			return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
			
		}
	
		//Delete User
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
			userService.deleteUser(id);
			
			return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
			
		}

}



    


	


