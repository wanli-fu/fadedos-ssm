package com.fadedos.basic;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/19
 */
@Data
public class Person {
    private Integer id;
    private String name;
    private String[] emails;
    private List<String> addresses;
    private Map<String,String> qqs;
    private Properties p;

    private Set<String> tels;

    public Person() {
        System.out.println("Person.Person");
    }
}
