package com.fadedos;

import com.fadedos.dao.UserDao;
import com.fadedos.entity.User;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/30
 */
public class TestMybatis {
    /**
     * 用于测试: 查询总条数
     */
    @Test
    public void testQueryTotalCounts() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //查询所有
            Long totalCounts = userDao.queryTotalCounts();
            System.out.println("totalCounts = " + totalCounts);
            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }

    }

    /**
     * 用于测试: 分页查询
     */
    @Test
    public void testQueryByPage() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //查询所有
            List<User> users = userDao.queryByPage(0, 1);
            users.forEach(user -> System.out.println("user = " + user));

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }
    }

    /**
     * 用于测试: 模糊查询
     */
    @Test
    public void testQueryLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //查询所有
            List<User> users = userDao.queryLikeByName("陈");
            users.forEach(user -> System.out.println("user = " + user));

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }
    }

    /**
     * 用于测试: 基于id查询
     */
    @Test
    public void testQueryById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //查询所有
            User user = userDao.queryById(3);
            System.out.println("user = " + user);

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }
    }

    /**
     * 用于测试: 查询所有
     */
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //查询所有
            List<User> users = userDao.queryAll();
            users.forEach(user -> System.out.println(user));

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }
    }

    /**
     * 用于测试: 删除操作
     */
    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            //获取dao对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //删除

            int delete = userDao.delete(1);

            //返回删除的条数
            System.out.println("delete = " + delete);

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            MybatisUtils.close(sqlSession);
        }
    }

    /**
     * 用于测试: 更新操作 update
     */
    @Test
    public void testUpdate() {
        InputStream inputStream = null;
        try {
            //读取配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建Mybatis核心对象 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        System.out.println("sqlSession = " + sqlSession);

        //获取dao对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            //更新数据  需求: 有值更新  不存在保持原始值   1.先查获得对象 在然后修改  2.动态sql
            User user = new User();
            user.setId(5);
            user.setName("小陈陈");
//            user.setAge(13);
//            user.setBir(new Date());

            int update = userDao.update(user);//预编译了sql

            //返回修改的条数
            System.out.println("update = " + update);

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            sqlSession.close();  //关闭资源
        }
    }


    /**
     * 用于测试: 用于读取mybatis-config.xml userDao.save(user); 增
     */
    @Test
    public void testSave() {
        InputStream inputStream = null;
        try {
            //读取配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建Mybatis核心对象 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        System.out.println("sqlSession = " + sqlSession);

        //获取dao对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {
            User user = new User();

            user.setName("小张");
            user.setAge(18);
            user.setBir(new Date());

            int count = userDao.save(user);  //预编译了sql
            //影响的条数
            System.out.println("count = " + count);

            //数据当前保存这条记录id
            System.out.println(user.getId());

            sqlSession.commit();  //提交  //确认数据库插入
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback(); //回滚
        } finally {
            sqlSession.close();  //关闭资源
        }
    }
}
