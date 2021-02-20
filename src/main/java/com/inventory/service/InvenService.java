package com.inventory.service;

import java.io.IOException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.inventory.entity.Inventory;

public interface InvenService {
		
	List<Inventory> getAll() throws DataAccessException, IOException;

	void save(Inventory inven) throws DataAccessException, IOException;

	void update(Inventory inven) throws DataAccessException, IOException;

	void delete(int id) throws DataAccessException, IOException;

	Inventory getById(int id) throws DataAccessException, IOException;

}