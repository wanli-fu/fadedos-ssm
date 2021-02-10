package com.fadedos;

import com.fadedos.aop.AppConfig;
import com.fadedos.aop.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
public class TestAnnotation1 {
    /**
     * 用于测试:AOP
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");

        userServiceImpl.register();
        userServiceImpl.login();
    }
}
