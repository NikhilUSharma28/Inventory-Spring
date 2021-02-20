package com.inventory.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "country")
public class Countries{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryId;
	@Column(name = "sortName")
	private String sortName;
	private String name;
	@Column(name = "phoneCode")
	private int phoneCode;
	
	@OneToOne(mappedBy = "countries")
	private Address countryAdd;
	
	public Address getCountryAdd() {
		return countryAdd;
	}
	public void setCountryAdd(Address countryAdd) {
		this.countryAdd = countryAdd;
	}
	
	@OneToMany(mappedBy="countries")
    private List<States> statesinCountry = new ArrayList<States>();
	
	public List<States> getStatesinCountry() {
		return statesinCountry;
	}
	public void setStatesinCountry(List<States> statesinCountry) {
		this.statesinCountry = statesinCountry;
	}
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
	
}