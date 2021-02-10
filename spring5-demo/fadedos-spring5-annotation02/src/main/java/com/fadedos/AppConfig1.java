package com.fadedos;

import com.fadedos.bean.Customer;
import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserDaoImpl;
import com.fadedos.injection.UserService;
import com.fadedos.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Configuration
@PropertySource(value = {"classpath:init.properties"})
public class AppConfig1 {
    @Value("${id}")
    private Integer id;

    @Value("${name}")
    private String name;

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

/*    @Bean
    public UserService userService(UserDao userDao){
        UserServiceImpl userService = new UserServiceImpl();
        //依赖成员变量的set方法
        userService.setUserDao(userDao);
        return userService;
    }*/

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao());
        return userService;
    }

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setName("xiaohei");

        customer.setId(id);
        customer.setName(name);
        return customer;
    }
}
