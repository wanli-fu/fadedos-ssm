package com.fadedos.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component
@PropertySource(value = {"classpath:init.properties"})
public class Category {
    //静态 就不能赋值注入
    @Value("${id}")
    private static Integer id;

    @Value("${name}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Category.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
