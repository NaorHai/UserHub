package com.nice.naor.dao;

import com.nice.naor.model.User;

import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */
public interface UserDao {
     List<User> getAllUsers();
     User getUserById(int user_id);
     void updateUser(User _user);
     void deleteUserById(int id);
}
