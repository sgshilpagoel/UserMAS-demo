package com.java.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.entity.User;
import com.java.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	Logger logger = Logger.getLogger(UserController.class);
	
	@PostMapping(value = "/user/add")
	public String addUser(User user) {
		System.out.println("inside add user method...");
		service.addUser(user);
		System.out.println("user record added successfully...");
		//response.setStatus(200);
		return "User added successfully";
	}
	
	@PostMapping("/user/update")
	public String updateUser(User user) {
		logger.info("user id :"+user.getId());
		service.updateUser(user);
		logger.info("record updated successfully........");
		return "User updated successfully";
	}
	
    @GetMapping("/user/{username}")
	public User getUserById(@PathVariable("username") String username) {
    	logger.info("inside user by id method....");
		User user = service.getUserById(username);
		//logger.info("inside user by id method...."+ user.getusername());
		return user;
	}
    
	
    @GetMapping("/user/getAllUser")
	public List<User> getAllUser() {
    	logger.info("inside get all user method....");
    	List<User> userList = service.getAllUser();
		return userList ;
	}

    @GetMapping("/user/delete/{username}")
	public String deleteUser(@PathVariable("username") String username) {
    	logger.info("inside delete user method..."+username);
		service.deleteUser(username);
		logger.info("user record deleted successfully....");
		return "user deleted successfully";
	}
    
    @GetMapping("/user/{username}/{password}")
	public String validateUser(@PathVariable("username") String username,@PathVariable("password") String password) {
    	logger.info("inside user validation method....");
		String flag = service.validateUser(username,password);
		//logger.info("inside user by id method...."+ user.getusername());
		return flag;
	}
}
