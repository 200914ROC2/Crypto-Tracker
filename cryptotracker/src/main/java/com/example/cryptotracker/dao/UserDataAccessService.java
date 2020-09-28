package com.example.cryptotracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.cryptotracker.model.User;

//check what repository should actually be enclosed)
@Repository("fakeDao")
public class UserDataAccessService implements UserDao {

	//fakeDAOService had a list in place of db.  
	
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
		String sql = "select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  \n" + 
				"join portfolio p on (u.username = p.username);\n";
		// TODO Auto-generated method stub
		return null;
	}

}
