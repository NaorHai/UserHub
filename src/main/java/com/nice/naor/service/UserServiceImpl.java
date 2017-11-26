package com.nice.naor.service;
import com.nice.naor.dao.UserDao;
import com.nice.naor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        return allUsers.size() > 0 ? allUsers : null;
    }

    @Override
    public User getUserById(int user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public boolean updateUser(User _user) {
        try {
            userDao.updateUser(_user);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
         try {
             userDao.deleteUserById(id);
             return true;
         }
         catch (Exception e) {
             return false;
         }
    }
}
