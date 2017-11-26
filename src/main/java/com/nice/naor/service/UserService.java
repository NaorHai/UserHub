package com.nice.naor.service;

import com.nice.naor.model.User;

import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */
public interface UserService {
    List<User> getAllUsers();
    User getUserById(long user_id);
    boolean updateUser(User _user);
    boolean deleteUser(User _user);}
