package com.inventory.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.inventory.dao.UserDao;
import com.inventory.entity.User;

@Repository("userJPA")
public class UserDaoJpaImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void registerUser(User user){
    	entityManager.persist(user);
	}

	public int validateUser(final String email, final String password){
		Query query = entityManager.createQuery("select q from User q where q.email=:email and q.pass=:pass");
		query.setParameter("email", email);
	    query.setParameter("pass", password);
	    try {
	    query.getSingleResult();
	    return 1;
	    }catch (Exception e) {
	    	System.out.println("Error Cause: " + e);
	    		return 0;
		}
	}
}
