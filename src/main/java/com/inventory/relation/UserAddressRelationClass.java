/*
 * package com.inventory.relation;
 * 
 * import java.sql.SQLException; import java.util.ArrayList; import
 * java.util.List; import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory; import javax.persistence.Persistence;
 * import org.junit.Test; import com.inventory.entity.Address; import
 * com.inventory.entity.Cities; import com.inventory.entity.Countries; import
 * com.inventory.entity.States; import com.inventory.entity.User;
 * 
 * public class UserAddressRelationClass {
 * 
 * @Test public void testMethod() throws SQLException {
 * 
 * EntityManagerFactory entityManagerFactory =
 * Persistence.createEntityManagerFactory("pu"); EntityManager entityManager =
 * entityManagerFactory.createEntityManager();
 * entityManager.getTransaction().begin();
 * 
 * User user = new User(); user.setFirstname("user5");
 * user.setLastname("user5"); user.setEmail("user5@gmail.com");
 * user.setPassword("1234");
 * 
 * Cities city1 = GetData.getCityData(1); System.out.println("City id: "+
 * city1.getCityId());
 * 
 * States states1 = city1.getStates(); System.out.println("State id: "+
 * states1.getStateId());
 * 
 * Countries countries1 = states1.getCountries();
 * System.out.println("Country id: "+ countries1.getCountryId());
 * 
 * Address addr1 = new Address(); addr1.setAddressLine1("A-101");
 * addr1.setAddressLine2("abc"); addr1.setAddressLine3("def");
 * addr1.setAddressType("office"); addr1.setPincode(395009);
 * addr1.setCities(city1); addr1.setStates(states1);
 * addr1.setCountries(countries1); addr1.setUser(user);
 * 
 * List<Address> list = new ArrayList<Address>(); list.add(addr1);
 * user.setAddress(list);
 * 
 * entityManager.persist(user);
 * 
 * entityManager.getTransaction().commit(); entityManager.close();
 * entityManagerFactory.close(); } }
 */