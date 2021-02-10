package com.fadedos.converter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/21
 */
public class Person implements Serializable {
    private String name;
    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
