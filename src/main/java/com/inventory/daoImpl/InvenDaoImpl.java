package com.inventory.daoImpl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.inventory.DatabaseLoader.FileReaderUtil;
import com.inventory.dao.InvenDao;
import com.inventory.entity.Inventory;

@Repository
public class InvenDaoImpl implements InvenDao {

	private static final Logger LOG = LogManager.getLogger(InvenDaoImpl.class);
	@Autowired
	public JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Inventory> findAll() throws DataAccessException, IOException {
		LOG.info(FileReaderUtil.getQuery("Select_all"));
		return template.query(FileReaderUtil.getQuery("Select_all"), new RowMapper<Inventory>() {
			public Inventory mapRow(ResultSet rs, int rownumber) throws SQLException {
				Inventory inven = new Inventory();
				inven.setId(rs.getInt(1));
				inven.setName(rs.getString(2));
				inven.setRating(rs.getInt(3));
				return inven; 	
			}
		});
	}

	public void save(Inventory inven) throws DataAccessException, IOException {
		template.update(FileReaderUtil.getQuery("Insert_pro"), inven.getName(), inven.getRating());
		
	}

	public void update(Inventory inven) throws DataAccessException, IOException {
		template.update(FileReaderUtil.getQuery("Update_pro"), inven.getName(), inven.getRating(), inven.getId());
	}

	public void delete(int id) throws DataAccessException, IOException {
		template.update(FileReaderUtil.getQuery("Delete_pro"), id);
		
	}

	public Inventory findById(final int id) throws DataAccessException, IOException {
		return template.execute(FileReaderUtil.getQuery("Select_pro"), new PreparedStatementCallback<Inventory>() {
			public Inventory doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				Inventory inven = new Inventory();
				if (rs.next()) {
					String name = rs.getString("Product_Name");
					int rating = Integer.parseInt(rs.getString("Product_rating"));
					inven = new Inventory(id, name, rating);
				}
				return inven;
			}
		});
	}
}
