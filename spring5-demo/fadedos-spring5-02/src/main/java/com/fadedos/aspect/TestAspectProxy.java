package com.fadedos.aspect;

import com.fadedos.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/25
 */
public class TestAspectProxy {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");

//        userService.login("fadedos", "123456");

        userService.register(new User());
    }
}
