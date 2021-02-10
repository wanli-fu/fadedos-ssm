package com.fadedos;

import com.fadedos.bean.Customer;
import com.fadedos.bean.User;
import com.fadedos.four.Account;
import com.fadedos.four.AppConfig10;
import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserService;
import com.fadedos.scan.AppConfig5;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
public class TestAnnotation {
    /**
     * 用于测试: 配置bean
     */
    @Test
    public void test1() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.fadedos");
    }

    /**
     * 用于测试: @Bean注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        /*User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);*/

       /* Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);*/

        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }

    /**
     * 用于测试:对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u1 = (User) ctx.getBean("u");
        System.out.println("u1 = " + u1);


        User u2 = (User) ctx.getBean("u");
        System.out.println("u2 = " + u2);
    }

    /**
     * 用于测试: @Bean注解注入
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register();
    }

    /**
     * 用于测试: @Bean jdk类型的属性注入
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     * 用于测试: @ScanComponent 基本使用
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试: 多种配置   测试配置覆盖
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);

//        new ClassPathXmlApplicationContext("")  ---> 使用@ImportSource注解
    }

    /**
     * 用于测试: 解耦合
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class, AppConfig5.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.fadedos");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        System.out.println("userDao = " + userDao);
    }

    /**
     * 用于测试: 多配置bean的整合 basePackages
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.fadedos.config");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDao = " + userDao);
    }

    /**
     * 用于测试: 多配置bean的整合 @Import
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.fadedos.config.AppConfig1.class);
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDao = " + userDao);
    }

    /**
     * 用于测试: 跨配置进行注入
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.fadedos.config.AppConfig1.class);
//        UserDao userDao = (UserDao) ctx.getBean("userDao");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register();
    }

    /**
     * 用于测试: @Component注解 与配置Bean的整合
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.fadedos.config.AppConfig3.class);
        UserService userService = (UserService) ctx.getBean("userService");

        UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");//userDaoImpl 根据@Repository的id生成规则

       /* System.out.println("userService = " + userService);
        System.out.println("userDao = " + userDao);*/

        userService.register();
    }

    /**
     * 用于测试: <bean  标签与配置bean整合
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.fadedos.config.AppConfig4.class);
        UserService userService = (UserService) ctx.getBean("userService");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        System.out.println("userService = " + userService);
        System.out.println("userDao = " + userDao);

        userService.register();
    }

    /**
     * 用于测试: @Configuration 创建的Bean底层 用的是cglib
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");
        System.out.println("u = " + u);
    }

    /**
     * 用于测试: 四维一体开发
     */
    @Test
    public void  test15(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        Account account = (Account) ctx.getBean("account");
        System.out.println("account id " + account.getId());
        System.out.println("account name " + account.getName());
    }

    /**
     * 用于测试: 四维一体开发  @Bean注解
     */
    @Test
    public void  test16(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig10.class);
        Account account = (Account) ctx.getBean("account");
        System.out.println("account id " + account.getId());
        System.out.println("account name " + account.getName());
    }
}
