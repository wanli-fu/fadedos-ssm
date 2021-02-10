package com.fadedos.basic;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
public class UserDaoImpl  implements UserDao{
    @Override
    public void save(User user) {
        System.out.println("insert into user" + user);
    }

    @Override
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("query user name = " + name+"password ="+password);
    }
}
