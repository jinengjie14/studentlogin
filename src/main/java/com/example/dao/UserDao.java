package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;

@Repository  
	public interface UserDao extends CrudRepository<User,Long>{  
	  
	    public User findByEmailAndPassword(String email,String password);  
	  
	}