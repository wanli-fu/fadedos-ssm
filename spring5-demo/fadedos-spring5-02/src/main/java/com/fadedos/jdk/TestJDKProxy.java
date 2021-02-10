package com.fadedos.jdk;

import com.fadedos.proxy.User;
import com.fadedos.proxy.a.UserService;
import com.fadedos.proxy.a.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class TestJDKProxy {
    /*
       1.借用的类加载器 TestJDKProxy
                    UserServiceImpl 都可以

       2. JDK8.x之前
               final UserService userService = new UserServiceImpl();
 */
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserServiceImpl();

        //2. JDK创建动态代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //额外功能
                System.out.println("--------- proxy log -------------");

                //原始方法运行
                Object ret = method.invoke(userService, args);

                return ret;
            }
        };
        //返回代理实例
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);

        userServiceProxy.login("fadedos", "123456");
        userServiceProxy.register(new User());
    }
}
