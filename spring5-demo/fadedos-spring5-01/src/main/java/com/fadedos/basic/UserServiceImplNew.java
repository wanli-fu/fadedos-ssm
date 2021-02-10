package com.fadedos.basic;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
public class UserServiceImplNew  implements UserService{
    @Override
    public void register(User user) {
        System.out.println("UserServiceImplNew.register");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImplNew.login");
    }
}
