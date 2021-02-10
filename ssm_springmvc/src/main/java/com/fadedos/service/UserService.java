package com.fadedos.service;

import com.fadedos.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();
}
