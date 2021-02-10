package com.fadedos.dao;

import com.fadedos.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //保存用户
    int save(User user);

    //更新用户
    int update(User user);

    //删除
    int delete(Integer id);

    //查询所有
    List<User> queryAll();

    //根据id查询
    User queryById(Integer id);

    //模糊查询
    List<User> queryLikeByName(String name);

    //分页查询  //参数1 起始位置 mysql默认从索引0开始,第一条   参数2  每页显示记录数
    //规律: 起始位置索引 = (当前页-1)* 每页记录数   第几页(当前页) 从1开始
    List<User> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    Long queryTotalCounts();
}
