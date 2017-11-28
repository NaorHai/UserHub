package com.nice.naor.dao;

import com.nice.naor.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */

@Service
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    final static Logger logger = Logger.getLogger(UserDaoImpl.class);

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
        User user = null;
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", user_id));
        user = (User) criteria.uniqueResult();
        logger.info("Got user: " + user.toString());
        return user;
    }

    @Override
    @Transactional
    public void updateUser(User _user) {
        getSession().saveOrUpdate(_user);
        logger.info("Updated: " + _user.toString());
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        delete(getUserById(id));
        logger.info("User deleted with id: " + id);
    }
}
