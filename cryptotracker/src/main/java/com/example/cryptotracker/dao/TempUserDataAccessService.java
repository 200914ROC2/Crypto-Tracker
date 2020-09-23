package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class TempUserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id,user.getUsername()));
        return 1;
    }

    @Override
    public List<User> getAllUser() {
        return DB;
    }
}
