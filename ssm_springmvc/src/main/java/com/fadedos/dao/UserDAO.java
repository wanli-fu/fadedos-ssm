package com.fadedos.dao;

import com.fadedos.entity.User;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/3
 */
public interface UserDAO {
    void save(User user);
    List<User> findAll();

}
