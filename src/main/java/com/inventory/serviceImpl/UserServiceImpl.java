package com.inventory.serviceImpl;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.inventory.dao.UserDao;
import com.inventory.entity.User;
import com.inventory.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userJPA")
	private UserDao userDao;

	public void newUser(User user) throws IOException {
		userDao.registerUser(user);
	}

	public int loginUser(String email, String password) throws DataAccessException, IOException {
		return userDao.validateUser(email, password);
	}

}