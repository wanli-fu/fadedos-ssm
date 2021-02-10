package com.fadedos.service;

import com.fadedos.dao.UserDao;
import com.fadedos.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/26
 */
//@Transactional(rollbackFor = {Exception.class},noRollbackFor = {RuntimeException.class})
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) throws Exception {

    /*    //模拟当前事务等待3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        userDao.save(user);
//        throw new Exception("测试");
    }


    @Override
//    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void login(String name, String password) {

    }
}
