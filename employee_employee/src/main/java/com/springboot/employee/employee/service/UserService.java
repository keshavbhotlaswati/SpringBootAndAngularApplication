package com.springboot.employee.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.springboot.employee.employee.entities.User;

import com.springboot.employee.employee.repository.UserRepository;


@Service
public class UserService {

	
	
	@Autowired
	UserRepository  user_repos;
	
	
	
	public User geUserById(int id) {
		Optional<User> optEmp = user_repos.findById(id);
		
		if(optEmp.isPresent()) {
   		return optEmp.get();
		}
		
		return null;
	}
	public User save(User usr) {
		return user_repos.save(usr);
	}
	 
	
	public List<User> getUserByUsername(String name) {
   		List<User> optEmp = user_repos.findByUsername(name);
		
    	if(optEmp.size()>0) {
		return optEmp;
	}		
		return null;
	}
	
	
	
	
	
	public List<User> getUser(){
		List<User> user=user_repos.findAll();
		user.forEach(System.out::println);
		return user;
	}
	
	public User remove(int id) {
     	Optional<User> optUser = user_repos.findById(id);
		
		if(optUser.isPresent()) {
			User u = optUser.get();
			user_repos.delete(u);
			return u;
		}
		
		return null;
	}
	
	public User update(int id, User user1) {
		
		return user_repos.findById(id).map(
				
				user-> {user.setFirstName(user1.getFirstName());
				user.setLastName(user1.getLastName());
				user.setPassword(user1.getPassword());
				user.setUsername(user1.getUsername());
				user.setWorkExperience(user1.getWorkExperience());
						
						
				
				user_repos.save(user);
				return user;
				}
				
				).orElse(null);
				
				
		
		
		
	}
	
}
