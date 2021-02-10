package com.fadedos;

import com.fadedos.mybatis01.*;
import com.fadedos.yml.Account;
import com.fadedos.yml.YmlAutoConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
public class TestAnnotation2 {
    /**
     * 用于测试:  Spring + mybatis 注解整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MybatisAutoConfiguration.class);
        UserDao userDao = (UserDao) ctx.getBean("userDao");

        User user = new User();
        user.setName("honghong");
        user.setPassword("4564654564");
        userDao.save(user);
    }

    /**
     * 用于测试:  纯注解版 事务开发
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.fadedos.mybatis01");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        User user = new User();
        user.setName("txAnnotation");
        user.setPassword("123456");
        userServiceImpl.register(user);
    }

    /**
     * 用于测试: YML
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(YmlAutoConfiguration.class);
        Account account = (Account) ctx.getBean("account");
        /*System.out.println("account name " + account.getName());
        System.out.println("account password " + account.getPassword());*/

        List<String> list = account.getList();
        for (String s : list) {
            System.out.println("s = " + s);
        }

    }
}
