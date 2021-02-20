package com.inventory.serviceImpl;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.inventory.dao.InvenDao;
import com.inventory.entity.Inventory;
import com.inventory.service.InvenService;

@Service
@Transactional
public class InvenServiceImpl implements InvenService {

	@Autowired
	@Qualifier("invenJPA")
	private InvenDao invenDao;

	public List<Inventory> getAll() throws DataAccessException, IOException {
		return invenDao.findAll();
	}

	public void save(Inventory inven) throws DataAccessException, IOException {
		invenDao.save(inven);
	}

	public void update(Inventory inven) throws DataAccessException, IOException {
		invenDao.update(inven);
	}

	public void delete(int id) throws DataAccessException, IOException {
		invenDao.delete(id);
	}

	public Inventory getById(int id) throws DataAccessException, IOException {
		return invenDao.findById(id);
	}
}