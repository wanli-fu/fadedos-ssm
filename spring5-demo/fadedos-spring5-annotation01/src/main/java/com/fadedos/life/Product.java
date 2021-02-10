package com.fadedos.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component
public class Product {
    @PostConstruct
    public void myInit(){
        System.out.println("Product.myInit");
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("Product.myDestroy");
    }
}
