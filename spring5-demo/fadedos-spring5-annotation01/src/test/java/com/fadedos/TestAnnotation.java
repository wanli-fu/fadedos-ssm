package com.fadedos;

import com.fadedos.bean.User;
import com.fadedos.injection.Category;
import com.fadedos.injection.UserService;
import com.fadedos.lazy.Account;
import com.fadedos.scope.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
public class TestAnnotation {


    /**
     * 用于测试: @Component注解
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);
    }

    /**
     * 用于测试: @Scope注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);

        Customer customer1 = (Customer) ctx.getBean("customer");
        System.out.println("customer1 = " + customer1);
    }

    /**
     * 用于测试: @lazy注解 默认true
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account = (Account) ctx.getBean("account");

    }


    /**
     * 用于测试: 生命周期相关注解 @PostConstruct  @PerDestroy
     */
    @Test
    public void test4() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ctx.close();

    }

    /**
     * 用于测试: @AutoWired注解
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        userServiceImpl.register(new User());
    }

    /**
     * 用于测试: @value注解
     */
    @Test
    public void  test6(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category = " + category);
    }
    
    /**
     * 用于测试: 扫描包的排除策略
     */
    @Test
    public void  test7(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
