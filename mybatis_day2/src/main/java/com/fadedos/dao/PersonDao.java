package com.fadedos.dao;

import com.fadedos.entity.Person;

import java.util.List;

public interface PersonDao {

    //保存用户信息
    int save(Person person);

    //查询所有用户信息
    List<Person> queryAll();
}
