package com.fadedos.config;

import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserDaoImpl;
import com.fadedos.injection.UserService;
import com.fadedos.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Configuration
@ComponentScan(basePackages = "com.fadedos.injection")
public class AppConfig3 {
    @Autowired
    private UserDao userDao;
    @Bean
    public UserService userService(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        return userService;
    }
}
