package com.fadedos.aspect;

import com.fadedos.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
