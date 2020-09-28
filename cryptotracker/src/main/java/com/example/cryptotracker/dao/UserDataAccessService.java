package com.example.cryptotracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cryptotracker.model.User;

//check what repository should actually be enclosed)
@Repository("userdao")
public class UserDataAccessService implements UserDao {

	private final JdbcTemplate jdbcTemplate;	
	
	    @Autowired
	    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
	@Override
	public User insertUser(User user) {
		String sql = "insert into users (username,email,hashed_password) values ('?','?','?')";
		return user;
		// TODO Auto-generated method stub

	}

	@Override
	public User updateUser(User user) {
		String sqlUserInfo = "update users set email = 'orange@gmail.com',\n" + 
				"hashed_password = 'newPass'\n" + 
				"where username = 'becca' and hashed_password = 'password';";
		
		String sqlPortfolio = "insert into portfolio (record_id, username, currency) values (default, '?','?');\n";
		
		return null;
	}

	@Override
	public User getUser(String username, String password) {
		String sql = "select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  \n" + 
				"join portfolio p on (u.username = p.username)\n" + 
				"where u.username = '?' and u.hashed_password = '?';";
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		final String sql = "select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  \n" + 
				"join portfolio p on (u.username = p.username);\n";
		return jdbcTemplate.query(sql, (resultSet,i) -> {
			int id = resultSet.getInt("user_id");
			String username = resultSet.getString("username");
			String email = resultSet.getString("email");
			String password = resultSet.getString("hashed_password");
					
					return new User(id,username, password, email);
		});
	}

	@Override
	public void updateUserPortfolio() {
		// TODO Auto-generated method stub
		
	}

}
