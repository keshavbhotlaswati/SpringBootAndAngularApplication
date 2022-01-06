package com.springboot.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.employee.entities.Employee;
import com.springboot.employee.employee.entities.User;
import com.springboot.employee.employee.exceptions.EmployeeNotFoundException;
import com.springboot.employee.employee.service.EmployeeService;
import com.springboot.employee.employee.service.UserService;


@RestController
public class UserController {

	
	
	@Autowired
	UserService user_service;
	
	
	@GetMapping("/User")
	public List<User> getUser() {
		return user_service.getUser();
	}
	
	
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable("userId") int id) throws Exception{
		User user = user_service.geUserById(id);
		 
		 if(user==null) {
				 
			 throw new Exception("id" + id);
			 
		 }
		 return user;
	}
	
	@GetMapping("/user/username/{username}")
	public List<User> getUserByName(@PathVariable("username") String username) throws Exception{
		
		
		
		 List<User> employeeByName = user_service.getUserByUsername(username);
		 
		 if(employeeByName.size()==0) {
			 throw new Exception("employee details not found ");
		 }
		 
		 return employeeByName;
		 
	}
	
	
	

	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.OK)
	public User saveUser(@RequestBody User user) throws Exception {
		
	if(user.getUsername()!=null)
				return user_service.save(user);
		
		throw new Exception("user name is not valid");
	}   
	
	

	

	
	@PutMapping("/user/{userId}")
	public User update(@PathVariable("userId") int id, @RequestBody User user) {
		return user_service.update(id, user);
	}
	
	@DeleteMapping("/user/{userId}")
	public User deleteUser(@PathVariable("userId")int id) {
		return user_service.remove(id);
	}
	
	
	
	
	
	


}

