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
    public User getUserById(long user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public boolean updateUser(User _user) {
        User entity = userDao.getUserById(_user.get_id());
        if(entity!=null){
            entity.set_name(_user.get_name());
            entity.set_email(_user.get_email());
            entity.set_address(_user.get_address());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User _user) {
         try {
             userDao.deleteUser(_user);
             return true;
         }
         catch (Exception e) {
             return false;
         }
    }
}
