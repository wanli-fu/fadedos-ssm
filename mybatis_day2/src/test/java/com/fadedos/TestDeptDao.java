package com.fadedos;

import com.fadedos.dao.DeptDao;
import com.fadedos.entity.Dept;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestDeptDao {
    /**
     * 用于测试: 查询首页部门
     */
    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptDao deptDao = sqlSession.getMapper(DeptDao.class);

        List<Dept> deptList = deptDao.queryAll();
        deptList.forEach(dept -> {
            System.out.println("部门信息:====>" + dept);
            dept.getEmps().forEach(emp -> System.out.println("员工信息:=====> " + emp));
            System.out.println("--------------------");
        });

        MybatisUtils.close(sqlSession);
    }
}
