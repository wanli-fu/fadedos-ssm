package com.fadedos;

import com.fadedos.dao.PersonDao;
import com.fadedos.entity.Person;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestPersonDao {
    /**
     * 用于测试: 查询所有用户信息
     */
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);

        List<Person> personList = personDao.queryAll();
        personList.forEach(person -> System.out.println("当前用户信息:" + person +"身份信息:" + person.getInfo()));
        MybatisUtils.close(sqlSession);
    }

    /**
     * 用于测试: 保存用户信息
     */
    @Test
    public void testSavePerson() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);

        try {
            Person person = new Person();
            person.setName("小陈");
            person.setAge(23);
            person.setCardno("13646354856556");
            int count = personDao.save(person);
            System.out.println("count = " + count);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
