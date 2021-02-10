package com.fadedos.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class Before1  implements MethodBeforeAdvice {
    /*
     作用: 需要把运行在原始方法之前运行的额外功能,书写在before方法中
     Method: 额外功能所增加给的那个原始方法
            login方法

            register方法

     Object[]: 额外功能所增加给的那个原始方法的参数
              login()方法的 String name,String password
              register() 方法 User

    Object: 额外功能所增加的那个原始对象
            UserServiceImpl
            OrderServiceImpl
    */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("----- new method before advice  log ------");
    }
}
