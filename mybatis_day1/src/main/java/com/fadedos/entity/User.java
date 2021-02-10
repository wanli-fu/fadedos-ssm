package com.fadedos.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/30
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Date bir;
}
