package com.fadedos;

import com.fadedos.bean.Customer;
import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Configuration
//@ImportResource("classpath:ApplicationContext.xml")
public class AppConfig4 {
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }
}
