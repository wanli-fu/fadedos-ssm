package com.fadedos.proxy;

import com.fadedos.proxy.a.UserService;
import com.fadedos.proxy.a.UserServiceImpl;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class UserServiceProxy implements UserService {
    //原始对象
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        //增加日志功能
        System.out.println("-----log-----");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        //增加日志功能
        System.out.println("-----log-----");
        return userService.login(name, password);
    }
}
