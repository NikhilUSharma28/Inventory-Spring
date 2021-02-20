package com.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	@Id
	@Column(name = "Product_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId; // productId
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Product_rating")
	private int productRating;

	public Inventory(int id, String name, int rating) {
		this.productId = id;
		this.productName = name;
		this.productRating = rating;
	}

	public Inventory(String name, int rating) {
		this.productName = name;
		this.productRating = rating;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public int getRating() {
		return productRating;
	}

	public void setRating(int rating) {
		this.productRating = rating;
	}
}