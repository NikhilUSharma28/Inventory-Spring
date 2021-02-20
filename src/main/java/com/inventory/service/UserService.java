package com.inventory.service;

import java.io.IOException;
import org.springframework.dao.DataAccessException;
import com.inventory.entity.User;

public interface UserService {

	void newUser(User user) throws IOException;

	int loginUser(String email, String password) throws DataAccessException, IOException;

}