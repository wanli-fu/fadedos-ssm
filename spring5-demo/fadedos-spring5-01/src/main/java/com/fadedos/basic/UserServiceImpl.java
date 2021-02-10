package com.fadedos.basic;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
public class UserServiceImpl implements UserService {
//    private UserDao userDao = new UserDaoImpl();

//    //使用工厂模式
//    private UserDao userDao = (UserDao) BeanFactory.getBean("userDao");

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

    @Override
    public void login(String name, String password) {
        userDao.queryUserByNameAndPassword(name, password);
    }
}
