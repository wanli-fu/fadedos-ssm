package com.fadedos;

import com.fadedos.dao.DeptDao;
import com.fadedos.dao.EmpDao;
import com.fadedos.entity.Dept;
import com.fadedos.entity.Emp;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestEmpDao {
    /**
     * 用于测试: 查询所有员工
     */
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        List<Emp> emps = empDao.queryAll();
        emps.forEach(emp -> {
            System.out.println("员工信息===> " + emp+"部门信息:"+emp.getDept());
        });

        MybatisUtils.close(sqlSession);

    }
}
