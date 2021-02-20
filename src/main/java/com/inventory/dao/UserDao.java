package com.inventory.dao;

import java.io.IOException;

import org.springframework.dao.DataAccessException;

import com.inventory.entity.User;

public interface UserDao{

	void registerUser(User user) throws IOException;

	int validateUser(String email, String password) throws DataAccessException, IOException;
	
}