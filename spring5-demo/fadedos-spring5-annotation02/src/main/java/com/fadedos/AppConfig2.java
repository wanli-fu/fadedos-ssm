package com.fadedos;

import com.fadedos.bean.Customer;
import com.fadedos.bean.User;
import com.fadedos.injection.UserDao;
import com.fadedos.injection.UserDaoImpl;
import com.fadedos.injection.UserService;
import com.fadedos.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Configuration
/*@ComponentScan(basePackages = "com.fadedos.scan",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"*..User1"})})*/
/*@ComponentScan(basePackages = "com.fadedos.scan",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})*/
@ComponentScan(basePackages = "com.fadedos.scan")
@Import(User.class)
public class AppConfig2 {

}
