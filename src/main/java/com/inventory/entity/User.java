package com.inventory.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "Firstname")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "pass")
	private String pass;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<Address>();
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}
	public User(String firstname, String lastname, String email, String password) {
		super();
		firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.pass = password;
	}
	public User() {
		super();
	}

}