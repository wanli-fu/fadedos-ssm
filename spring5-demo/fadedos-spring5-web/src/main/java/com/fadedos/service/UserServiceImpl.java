package com.fadedos.service;

import com.fadedos.dao.UserDao;
import com.fadedos.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/27
 */
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
            userDao.save(user);
    }
}
