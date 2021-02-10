package com.fadedos.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
public class BeanFactory {

    private static Properties env = new Properties();
    static {
        try {
            //第一步 获得Io流
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            //第二步 文件内容 封装 Properties集合中 key = userservice  value = com.fadedos.basic.UserService
            env.load(inputStream);

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


/*    对象的创建方式:
        1.直接调用构造方法 创建对象  UserServiceImpl userServiceImpl = new UserServiceImpl();
        2.通过反射的方式 创建对象 解耦合
            Class clazz = Class.forName("com.fadedos.basic.UserServiceImpl");
            Userservice userservice = clazz.newInstance();*//*

    public static UserService getUserService() {

        UserService userService = null;
        try {
//            Class<?> aClass = Class.forName("com.fadedos.basic.UserServiceImpl");
            Class<?> aClass = Class.forName(env.getProperty("userService"));
            userService = (UserService) aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static UserDao getUserDao() {
        UserDao userDao = null;
        try {
            Class<?> aClass = Class.forName(env.getProperty("userDao"));
            userDao = (UserDao) aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userDao;
    }*/

    /**
     * @param key 小配置文件中的key [userService userDao]
     * @return
     */
    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class aClass = Class.forName(env.getProperty(key));
            ret = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
