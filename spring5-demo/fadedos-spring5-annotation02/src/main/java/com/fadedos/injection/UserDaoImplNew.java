package com.fadedos.injection;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
public class UserDaoImplNew implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImplNew.save");
    }
}
