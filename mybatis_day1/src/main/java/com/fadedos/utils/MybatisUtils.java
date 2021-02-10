package com.fadedos.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/30
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建Mybatis核心对象 SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 提供sqlSession
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        //获取session
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭sqlSession
     *
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession) {
        sqlSession.close();
    }
}
