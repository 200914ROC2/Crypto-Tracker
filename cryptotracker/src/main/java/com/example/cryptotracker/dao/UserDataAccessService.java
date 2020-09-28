package com.example.cryptotracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cryptotracker.model.Crypto;
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
		String sqlUserInfo = "insert into users (username,email,hashed_password) values ('"
	+ user.getUsername() + "', '" + user.getEmail() + "', '" + user.getPassword() + "'); ";
			return user;
		// TODO Auto-generated method stub

	}

	@Override
	public User updateUser(User user) {
		String sql = "update users set email = 'orange@gmail.com',\n" + 
				"hashed_password = 'newPass'\n" + 
				"where username = 'becca' and hashed_password = 'password';";		
		return null; 
//				jdbcTemplate.query(sql, (resultSet,i) -> {
//			int id = 
//		});
	}

	@Override
	public User getUser(String username, String password) {
		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u\n" + 
				"where u.username = ? and u.hashed_password = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{username, password},
				BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public List<User> getAllUsers() {
		final String sql = "select u.user_id, u.username , u.email , u.hashed_password from users u;";
		return jdbcTemplate.query(sql, (resultSet,i) -> {
			int id = resultSet.getInt("user_id");
			String username = resultSet.getString("username");
			String email = resultSet.getString("email");
			String password = resultSet.getString("hashed_password");
					
					return new User(id,username, password, email);
					//test only
		});
	}
	
	@Override
	public List<Crypto> getPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crypto> addToPortfolio() {
		String sql = "insert into portfolio (record_id, username, currency) values (default, '?','?');\n";
		return null;
	}

	@Override
	public List<Crypto> removeFromPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

}
