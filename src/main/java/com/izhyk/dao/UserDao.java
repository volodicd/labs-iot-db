package com.izhyk.dao;

import com.izhyk.domain.User;

import java.util.Optional;


public interface UserDao extends GeneralDao<User, Integer> {
    Optional<User> findByUserLastName (String lastName);

}
