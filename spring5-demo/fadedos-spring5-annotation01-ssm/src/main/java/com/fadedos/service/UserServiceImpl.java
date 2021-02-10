package com.fadedos.service;

import com.fadedos.dao.UserDao;
import com.fadedos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/27
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void register(User user) {
            userDao.save(user);
    }
}
