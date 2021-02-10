package com.fadedos;

import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestMybatis {
    /**
     * 用于测试: 测试环境是否ok
     */
    @Test
    public void testSqlSession() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
    }
}
