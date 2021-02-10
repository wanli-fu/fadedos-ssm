package com.fadedos.injection;

import org.springframework.stereotype.Repository;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
//@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoImpl.save");
    }
}
