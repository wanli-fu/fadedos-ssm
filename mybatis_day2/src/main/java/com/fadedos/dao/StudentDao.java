package com.fadedos.dao;

import com.fadedos.entity.Student;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public interface StudentDao {
    //查询学生信息,并查询所选课程
    Student queryById(Integer id);
}
