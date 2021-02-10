package com.fadedos.dao;

import com.fadedos.entity.Dept;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public interface DeptDao {
    //查询所有部门id
    List<Dept> queryAll();

}
