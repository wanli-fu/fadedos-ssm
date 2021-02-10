package com.fadedos.proxy.a;

import com.fadedos.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
