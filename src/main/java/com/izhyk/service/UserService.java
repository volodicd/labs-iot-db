package com.izhyk.service;

import com.izhyk.domain.User;

import java.util.Optional;

public interface UserService extends GeneralService<User, Integer> {
    Optional<User> findByUserLastName (String lastName);
}
