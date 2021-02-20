package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//new

@Entity
@Table(name = "city")
public class Cities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	private String name;

	@OneToOne(mappedBy = "cities")
	private Address cityAdd;

	public Address getCityAdd() {
		return cityAdd;
	}

	public void setCityAdd(Address cityAdd) {
		this.cityAdd = cityAdd;
	}

	@ManyToOne
	@JoinColumn(name = "stateId", nullable = false)
	private States states;

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}