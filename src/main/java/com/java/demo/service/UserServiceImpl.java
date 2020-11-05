package com.java.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.UserDao;
import com.java.demo.entity.User;


@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;
	
	
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	

	@Override
	public void addUser(User user) {
		
		logger.info("inside add user serviceImpl method");
		dao.save(user);
		
	}

	@Override
	public void updateUser(User user) {
	  logger.info("inside user service impl for update.....");
      dao.save(user);
		
	}

	@Override
	public User getUserById(String username) {
		logger.info("inside get user by id serviceImpl method");
		return dao.findOne(username);
		
	}

	@Override
	public List<User> getAllUser() {
		logger.info("inside get all user serviceImpl method");
		List<User> result = dao.findAll();
    	logger.info("result is :"+result);
		
		System.out.println(dao);
		return result;
		
	}

	@Override
	public void deleteUser(String username) {
		logger.info("inside delete user serviceImpl method");
		User user =new User();
		user.setUsername(username);
		dao.delete(username);
	}
	@Override
	public String validateUser(String username,String password) {
		logger.info("inside validate user serviceImpl method");
		User user = dao.findOne(username);
		if(null != user)
		{
			if (user.getPassword().equals(password))
			{
				user.setLastLogin(java.time.LocalDateTime.now().toString());
				dao.save(user);
				return "Valid user.You have been successfully authenticated";
			}
			return "Incorrect password.Please try again";
		}
		
		return "User doesn't exist";
	}
}
