package com.fadedos.cglib;

import com.fadedos.proxy.User;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class UserService {
    public void login(String name,String password){
        System.out.println("UserService.login");
    }

    public void register(User user) {
        System.out.println("UserService.register");
    }
}
