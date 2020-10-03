package com.example.cryptotracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cryptotracker.model.User;

//check what repository should actually be enclosed)
@Repository("userDao")
public class UserDataAccessService implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User insertUser(User user) {// Working now Might need a try catch?
		String sqlUserInfo = "insert into users (username,email,hashed_password) values (?,?,?)";
		try {
		jdbcTemplate.update(sqlUserInfo,user.getUsername(),user.getEmail(),user.getPassword());
		} catch(Exception e)   {
			user = null;
		}
		return user;
		//needs to return NOT THE INPUT. 
		
	}
	

	@Override
	public User getUser(User user) {
		
		String sql = "select user_id, username, hashed_password, email from users "
				+ "where username = '" + user.getUsername() + "' and hashed_password = '" + user.getPassword() + "' ;";

		List<User> userList = jdbcTemplate.query(sql, (resultSet, i) -> {
			int id = resultSet.getInt("user_id");
			String username = resultSet.getString("username");
			String email = resultSet.getString("email");
			String password = resultSet.getString("hashed_password");

			return new User(id, username, password, email);

		});
		userList.get(0).setPortfolio(getPortfolio(user));
		return userList.get(0);
	}

	@Override
	public List<User> getAllUsers() {
		final String sql = "select user_id, username , email , hashed_password from users ";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			int id = resultSet.getInt("user_id");
			String username = resultSet.getString("username");
			String email = resultSet.getString("email");
			String password = resultSet.getString("hashed_password");

			return new User(id, username, password, email);
			// test only
		});
	}

	@Override
	public List<String> getPortfolio(User user) {
		final String sql = "select currency from portfolio where username = '"+ user.getUsername() + "';";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			String crypto = resultSet.getString("currency");

			return new String(crypto);
		});
	}

	@Override
	public List<String> getUserStringPortfolio(User user) {
		final String sql = "select username, currency from portfolio where username = '" + 
				user.getUsername() + "';";
		return jdbcTemplate.query(sql,(resultSet, i) -> {
			String username = resultSet.getString("username");
			String crypto = resultSet.getString("currency");	

			return new String(username + "." + crypto);
		});
	}
	
	@Override
	public void addToPortfolio(User user, String cryptocurrency) {
		String sql = "insert into portfolio (record_id, username, currency) values (default, '?','?');";
		
		jdbcTemplate.update(sql,user.getUsername(),cryptocurrency);

	}
	
//	String sqlUserInfo = "insert into users (username,email,hashed_password) values (?,?,?)";
//	try {
//	jdbcTemplate.update(sqlUserInfo,user.getUsername(),user.getEmail(),user.getPassword());


	@Override
	public List<String> removeFromPortfolio(User user, String cryptocurrency) {
		// TODO Auto-generated method stub
		return null;
	}

}
