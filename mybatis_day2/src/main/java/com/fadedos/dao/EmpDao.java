package com.fadedos.dao;

import com.fadedos.entity.Emp;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public interface EmpDao {
    //查询所有员工
    List<Emp> queryAll();
}
