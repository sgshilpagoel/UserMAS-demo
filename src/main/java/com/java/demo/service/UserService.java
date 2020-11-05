package com.java.demo.service;

import java.util.List;

import com.java.demo.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUserById(String username);
	
	public List<User> getAllUser();
	
	public void deleteUser(String username);
	
	public String validateUser(String username,String password);

}
