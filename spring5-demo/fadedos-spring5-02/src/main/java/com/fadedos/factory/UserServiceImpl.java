package com.fadedos.factory;

import com.fadedos.proxy.User;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/25
 */
public class UserServiceImpl implements UserService {
    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }
}
