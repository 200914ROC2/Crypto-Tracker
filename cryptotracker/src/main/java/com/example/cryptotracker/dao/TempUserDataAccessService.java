package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Temporary database
@Repository("fakeDao")
public class TempUserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(User user) {
        DB.add(user);
        return 1;
    }

    @Override
    public List<User> getAllUser() {
        return DB;
    }
}
