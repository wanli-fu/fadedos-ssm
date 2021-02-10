import com.fadedos.proxy.*;
import com.fadedos.proxy.a.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class TestProxy {
    /**
     * 用于测试: 静态代理的代码
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.login("fadedos", "123456");
        userService.register(new User());

        System.out.println("------------------------------------");

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 用于测试: Spring的动态代理
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        boolean result = userService.login("fadedos", "123456");
        System.out.println("result = " + result);

        userService.register(new User());
    }

    /**
     * 用于测试: orderService的动态代理
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");

        orderService.showOrder();
    }

}
