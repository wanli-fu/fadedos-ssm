package com.fadedos.config;

import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Configuration
public class AppConfig2 {
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }
}
