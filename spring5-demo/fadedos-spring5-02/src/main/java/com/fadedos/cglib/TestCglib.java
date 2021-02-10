package com.fadedos.cglib;

import com.fadedos.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class TestCglib {
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserService();

        /*
            2.通过cglib方式创建动态代理对象
            proxy.newProxyInstance(classloader,interfaces,invocationHandler)

            Enhancer.setClassLoader()
            Enhancer.setSuperClass()
            Enhancer.setCallback()  ----> MethodInterceptor(Cglib)
            Enhancer.create()   ---> 代理
         */

        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            //等同于 InvocationHandler --->invoke
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //额外功能
                System.out.println("------ cglib  log -------");
                //原始方法运行
                Object ret = method.invoke(userService, objects);
                return ret;
            }
        };
        enhancer.setCallback(interceptor);

        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("fadedos","123456");
        userServiceProxy.register(new User());
    }
}
