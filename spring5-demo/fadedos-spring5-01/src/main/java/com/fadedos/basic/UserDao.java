package com.fadedos.basic;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
public interface UserDao {
    public void save(User user);

    public void queryUserByNameAndPassword(String name, String password);
}
