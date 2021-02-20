package com.inventory.daoImpl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.inventory.DatabaseLoader.FileReaderUtil;
import com.inventory.dao.UserDao;
import com.inventory.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	public JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	FileReaderUtil dbobject = FileReaderUtil.getInstance();

	public void registerUser(User user) throws DataAccessException, IOException {
		template.update(FileReaderUtil.getQuery("Insert_user"), user.getFirstname(), user.getLastname(),
				user.getEmail(), user.getPassword());
	}

	public int validateUser(final String email, final String password) throws DataAccessException, IOException {
		return template.execute(FileReaderUtil.getQuery("Validate_User"), new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		// SQL Injection Attack prone code:-

//		int success = 0;
//		String query = "select * from userauth where email='" + email + "' and pass = '" + password + "'";
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_inventory", "root", "root");
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			if (rs.next()) {
//				success = 1;
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			try {
//				stmt.close();
//				conn.close();
//			} catch (Exception e) {
//			}
//		}
//		if (success==1) {
//			return 1;
//		} else {
//			return 0;
//		}

	}

}