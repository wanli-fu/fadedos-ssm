package com.fadedos.injection;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register() {
        userDao.save();
    }
}
