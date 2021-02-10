package com.fadedos.injection;

import com.fadedos.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("UserDaoImpl.save");
    }
}
