package com.inventory.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.inventory.dao.InvenDao;
import com.inventory.entity.Inventory;

@Repository("invenJPA")
public class InvenDaoJpaImpl implements InvenDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Inventory inven) {
		entityManager.persist(inven);
	}

	public void update(Inventory inven){
		entityManager.merge(inven);
	}

	public void delete(int id){
		Inventory inventory = entityManager.find(Inventory.class, id);
		entityManager.remove(inventory);
	}

	public Inventory findById(int id){
		Inventory productById = entityManager.find(Inventory.class, id);
		return productById;
	}

	public List<Inventory> findAll(){
		TypedQuery<Inventory> query = (TypedQuery<Inventory>) entityManager.createQuery("from Inventory", Inventory.class);
		List<Inventory> results = query.getResultList();
		return results;
	}
}
