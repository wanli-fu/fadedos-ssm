package com.fadedos.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component("u")
public class User implements Serializable {
    private  Integer id;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
