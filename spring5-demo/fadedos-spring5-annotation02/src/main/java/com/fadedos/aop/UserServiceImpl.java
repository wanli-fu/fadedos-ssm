package com.fadedos.aop;

import org.springframework.stereotype.Service;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}
