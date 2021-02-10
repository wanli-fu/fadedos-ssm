package com.fadedos.aspect;

import com.fadedos.Log;
import com.fadedos.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }


    @Log
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register  业务运算 + DAO");
//        throw new RuntimeException("测试异常");

        //this 是原始对象 调用的是原始对象的login方法  --->核心功能
        /*
                设计目的 :代理对象login方法  ---> 额外功能+核心功能
                ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
                UserService userService = (UserService) ctx.getBean("userService");
                userService.login();

                Spring工厂重量级资源 一个应用中 应该只创建一个工厂
         */
//        this.login("fadedos", "123456");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("fadedos", "123456");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
