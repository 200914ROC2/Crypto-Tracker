package com.example.cryptotracker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		if(jdbcTemplate.update(sqlUserInfo,user.getUsername(),user.getEmail(),user.getPassword()) == 1){
			//not sure how to make if there is a better way but just call a search query base on the user and return it.
		}
		return user;
//my old method
//	public User insertUser(User user) {
//		String sqlUserInfo = "insert into users (username,email,hashed_password) values ('" + user.getUsername()
//				+ "', '" + user.getEmail() + "', '" + user.getPassword() + "'); ";
//		return null;

	}

	@Override
	public User updateUser(User user) {
		String sql = "update users set email = 'orange@gmail.com',\n" + 
				"hashed_password = 'newPass'\n" + 
				"where username = ? and hashed_password = ?;";		
		return null; 

//				jdbcTemplate.query(sql, (resultSet,i) -> {
//			int id = 
//		});
	}

//	old
	//public User getUser(String username, String password) {
//		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u " + 
//				"where u.username = ? and u.hashed_password = ? ;";
//		return jdbcTemplate.queryForObject(sql, new Object[]{username, password},
//				BeanPropertyRowMapper.newInstance(User.class));
	@Override
	public Optional<User> getUser(String username, String password) {
		String sql = "select u.user_id, u.username, u.hashed_password, u.email from users u\n"
				+ "where u.username = ? and u.hashed_password = ?";

		User user = jdbcTemplate.queryForObject(
				sql,
				new Object[] { username, password },
				(resultSet, i) -> {
			int id = resultSet.getInt("user_id");
			String queriedUsername = resultSet.getString("username");
			String email = resultSet.getString("email");
			String queriedPassword = resultSet.getString("hashed_password");

			return new User(id, queriedUsername, queriedPassword, email);
		});

		return Optional.ofNullable(user);

//		return jdbcTemplate.queryForObject(sql, new Object[] { username, password },
//				BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public List<User> getAllUsers() {
		final String sql = "select u.user_id, u.username , u.email , u.hashed_password from users u;";
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
		final String sql = "select p.currency from users u  \n" + "join portfolio p on (u.username = p.username)\n"
				+ "where u.username = '" + username + " and u.hashed_password = '" + password + "';";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			String crypto = resultSet.getString("currency");

			return new Crypto(crypto);
			// test only
		});
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
