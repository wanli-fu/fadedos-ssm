package com.fadedos;

import com.fadedos.dao.StudentDao;
import com.fadedos.entity.Student;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestStudentDao {
    /**
     * 用于测试: 测试根据id获取学生信息
     */
    @Test
    public void testQueryById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.queryById(12);
        System.out.println("student = " + student);
        student.getCourses().forEach(course -> System.out.println("     course = " + course));
        MybatisUtils.close(sqlSession);
    }
}
