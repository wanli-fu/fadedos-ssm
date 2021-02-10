package Com.fadedos.test;

import com.fadedos.entity.User;
import com.fadedos.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/3
 */
public class TestUserService {
    /**
     * 用于测试:
     */
    @Test
    public void testUserService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        List<User> users = userServiceImpl.findAll();
        users.forEach(user-> System.out.println("user = " + user));
    }
}
