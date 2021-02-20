package com.inventory.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.entity.User;
import com.inventory.service.UserService;

@Controller
public class UserController{
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/register")
	public String showregform() {
		return "registrationForm";
	}
	
	@RequestMapping(value="/saveuser", method = RequestMethod.POST)
	private String savenewuser(User user) throws IOException{
		userservice.newUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	protected String service(@RequestParam("email") String email, @RequestParam("pass") String password) throws SQLException, DataAccessException, IOException{
		int status = userservice.loginUser(email, password);
			if(status==1){
			return "redirect:/list";
		} else {
			return "Invalid";
		}
	}
	
	@RequestMapping("/logout")
	protected String logoutUser(HttpSession session) throws ServletException, IOException, SQLException {
		session.invalidate();
		return "redirect:/";
	}
}