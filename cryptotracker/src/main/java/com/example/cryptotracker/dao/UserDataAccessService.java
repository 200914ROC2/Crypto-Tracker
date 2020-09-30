package com.example.cryptotracker.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.example.cryptotracker.model.Crypto;
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
	
//	old
	//public User getUser(String username, String password) {
//		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u " + 
//				"where u.username = ? and u.hashed_password = ? ;";
//		return jdbcTemplate.queryForObject(sql, new Object[]{username, password},
//				BeanPropertyRowMapper.newInstance(User.class));
//	@Override
//	public User getUser(String username, String password) {
//		String sql = "select user_id, username, hashed_password, email from users "
//				+ "where username = '" + username + "' and hashed_password = '" + password + "' ;";
//		
//		List<User> userList = jdbcTemplate.query(sql, (resultSet, i) -> {
//			int id = resultSet.getInt("user_id");
//			String dBusername = resultSet.getString("username");
//			String email = resultSet.getString("email");
//			String dBpassword = resultSet.getString("hashed_password");
//
//			return new User(id, dBusername, dBpassword, email);
//			// test only
//		});
////		return userList.get(0);

		
//		return jdbcTemplate.queryForObject(
//				sql,
//				new Object[] { username, password },
//				(resultSet, i) -> 
//			new User(
//			resultSet.getInt("user_id"),
//			resultSet.getString("username"),
//			resultSet.getString("hashed_password"),
//			resultSet.getString("email")
//			));	
//	//OR
//		User user = (User) jdbcTemplate.query(
//				sql, 
//				new Object[] { username, password },
//				BeanPropertyRowMapper.newInstance(User.class));
//		return user;
//	
//		


//	@Override
//	public User getUser(User user) {
//		System.out.println(user);
//		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u\n"
//				+ "where u.username = ? and u.hashed_password = ?";
//		return jdbcTemplate.queryForObject(
//				sql,
//				new Object[] { user.getUsername(), user.getPassword()},
//				BeanPropertyRowMapper.newInstance(User.class));
//	}
	@Override
	public User getUser(User user) {
		String sql = "select user_id, username, hashed_password, email from users "
				+ "where username = '" + user.getUsername() + "' and hashed_password = '" + user.getPassword() + "' ;";

		List<User> userList = jdbcTemplate.query(sql, (resultSet, i) -> {
			int id = resultSet.getInt("user_id");
			String dBusername = resultSet.getString("username");
			String email = resultSet.getString("email");
			String dBpassword = resultSet.getString("hashed_password");

			return new User(id, dBusername, dBpassword, email);
			// test only
		});
		return userList.get(0);

	}


	@Override
	public Optional<User> getOptionalUser(String username, String password) {
		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u\n"
				+ "where u.username = ? and u.hashed_password = ?;";

		return jdbcTemplate.queryForObject(
				sql,
				new Object[] { username, password },
				(resultSet, i) -> 
			Optional.of(new User(
			resultSet.getInt("user_id"),
			resultSet.getString("username"),
			resultSet.getString("hashed_password"),
			resultSet.getString("email")
			)));		
		
//		return (User) jdbcTemplate.queryForObject(
//				sql, 
//				new Object[] { username, password },
//				BeanPropertyRowMapper.newInstance(User.class));
	}
	
	@Override
	public List<User> getAllUsers() {
		final String sql = "select user_id, username , email , hashed_password from users " +
	"where username = 'tyrone' and hashed_password = 'password';";
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
	public List<Crypto> getPortfolio(String username, String password) {
		final String sql = "select currency from portfolio where username = ?;";
//		return jdbcTemplate.query(sql, {username, password}, (resultSet, i) -> {
//			String crypto = resultSet.getString("currency");
//
//			return new Crypto(crypto);
//			// test only
//		});
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
