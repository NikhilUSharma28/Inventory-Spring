package com.inventory.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class States {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateId;
	private String name;

	@OneToOne(mappedBy = "states")
	private Address statesAdd;

	public Address getStatesAdd() {
		return statesAdd;
	}

	public void setStatesAdd(Address statesAdd) {
		this.statesAdd = statesAdd;
	}

	@OneToMany(mappedBy = "states")
	private List<Cities> cities = new ArrayList<Cities>();

	@ManyToOne
	@JoinColumn(name = "countryId", nullable = false)
	private Countries countries;

	public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}

	public Countries getCountries() {
		return countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}