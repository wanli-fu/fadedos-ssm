package com.fadedos.factory;

import com.fadedos.proxy.User;

public interface UserService {
     void login(String name, String password);

    void register(User user);
}
