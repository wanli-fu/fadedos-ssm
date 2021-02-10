package com.fadedos.basic.constructor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/20
 */
@Data
public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int age) {
        this.age = age;
    }
}
