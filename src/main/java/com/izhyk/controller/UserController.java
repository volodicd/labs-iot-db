package com.izhyk.controller;


import com.izhyk.domain.User;

import java.util.Optional;

public interface UserController extends GeneralController<User, Integer> {
    Optional<User> findByUserLastName (String lastName);
}
