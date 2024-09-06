package com.curso.data.DAOO;

import com.curso.data.DAOO.Interfaces.UserDao;
import com.curso.data.entities.User;

import java.util.List;

public class UserHibernateDao extends AbstractDao<User,Long> implements UserDao {

    @Override
    public List<User> findByFirstName(String firstName) {
        //add implementation here...
        return null;
    }

}

