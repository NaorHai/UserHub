package com.nice.naor.dao;

import com.nice.naor.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */

@Service
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<User> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    @Override
    @Transactional
    public User getUserById(int user_id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", user_id));
        return (User) criteria.uniqueResult();
    }

    @Override
    @Transactional
    public void updateUser(User _user) {
        getSession().saveOrUpdate(_user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        delete(getUserById(id));
    }
}
