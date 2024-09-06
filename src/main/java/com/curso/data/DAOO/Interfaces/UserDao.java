package com.curso.data.DAOO.Interfaces;

import com.curso.data.entities.User;

import java.util.List;

public interface UserDao extends Dao<User,Long> {

    public List<User> findByFirstName(String firstName);
}

