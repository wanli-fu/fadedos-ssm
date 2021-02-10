package com.fadedos;

import com.fadedos.dao.UserDao;
import com.fadedos.entity.User;
import com.fadedos.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/25
 */
public class TestMybatisSpring {
    /**
     * 用于测试:Spring与Mybatis的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");

        User user = new User();
        user.setName("xiaojr");
        user.setPassword("99999");
        userDao.save(user);
    }


    /**
     * 用于测试:Spring的事务处理
     */
    @Test
    public void test2() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("xiaohei3");
        user.setPassword("654343546");
        userService.register(user);
    }


    /**
     * 用于测试:Spring的基于标签事务处理
     */
    @Test
    public void test3() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext-tx.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("xiaohei3");
        user.setPassword("654343546");
        userService.register(user);
    }
}
