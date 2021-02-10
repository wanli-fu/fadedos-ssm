package com.fadedos.dao;

import com.fadedos.entity.Info;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public interface InfoDao {
    //保存身份证信息
    int save(Info info);
}
