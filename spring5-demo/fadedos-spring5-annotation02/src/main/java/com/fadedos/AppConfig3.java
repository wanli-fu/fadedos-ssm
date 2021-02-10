package com.fadedos;

import com.fadedos.bean.Customer;
import com.fadedos.bean.User;
import org.springframework.context.annotation.*;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Configuration
@ComponentScan(basePackages = "com.fadedos.bean")
@ImportResource("classpath:ApplicationContext.xml")
public class AppConfig3 {
    @Bean
    public Customer customer(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("xiaobai");
        return customer;
    }
}
