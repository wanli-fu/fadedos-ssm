package com.fadedos.service;

import com.fadedos.entity.User;

public interface UserService {
    void register(User user) throws Exception;

    void login(String name, String password);
}
