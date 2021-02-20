package com.inventory.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.inventory.entity.Inventory;


public interface InvenDao{
	List<Inventory> findAll() throws DataAccessException, IOException;

	void save(Inventory inven) throws DataAccessException, IOException;

	void update(Inventory inven) throws DataAccessException, IOException;

	void delete(int id) throws DataAccessException, IOException;

	Inventory findById(int id) throws DataAccessException, IOException;

}