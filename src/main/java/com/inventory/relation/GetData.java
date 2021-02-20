package com.inventory.relation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.inventory.entity.Cities;

public class GetData {
	public static Cities getCityData(int cityId) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	entityManager.getTransaction().begin();
    
    Cities city = entityManager.find(Cities.class, cityId);
	
	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();
	return city;
	}
}
