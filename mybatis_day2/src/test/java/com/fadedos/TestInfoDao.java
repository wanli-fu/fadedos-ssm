package com.fadedos;

import com.fadedos.dao.InfoDao;
import com.fadedos.entity.Info;
import com.fadedos.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class TestInfoDao {
    /**
     * 用于测试: info保存信息
     */
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            InfoDao infoDao = sqlSession.getMapper(InfoDao.class);
            Info info = new Info();
            info.setCardno("13646354856556");
            info.setAddress("北京市朝阳区");

            int count = infoDao.save(info);
            System.out.println("count = " + count);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.close(sqlSession);
        }

    }
}
