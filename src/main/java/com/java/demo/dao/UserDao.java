package com.java.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.demo.entity.User;

@Repository
public interface UserDao extends CrudRepository<User,String> {
	

	@Override
	User findOne(String username);
	
	@Override
	List<User> findAll();
	
	@Override
	void delete(String entity);
	
	@Override
	<S extends User> S save(S entity);
}