package com.fadedos.injection;

import com.fadedos.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Service
@Qualifier
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

//    @Autowired
//    @Qualifier("userDaoImpl")
    public void setUserDao(UserDao userDao) {
        System.out.println("UserServiceImpl.setUserDao");
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.save(user);
    }
}
