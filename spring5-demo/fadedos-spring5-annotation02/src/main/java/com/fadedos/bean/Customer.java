package com.fadedos.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component
public class Customer implements Serializable {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
