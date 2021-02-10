package com.fadedos.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class Around implements MethodInterceptor {

    /*
            invoke方法的作用: 额外功能书写在invoke中
                            额外功能  可以运行在原始方法之前,
                                              原始方法之后
                                              原始方法之前之后.

          确定: 原始方法怎么运行

          参数: MethodInvocation: 额外功能所增加给的那个原始方法
                    login
                    register
               methodInvocation.proceed()  --->login运行
                                               register运行

          返回值: Object 原始方法返回值
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("-----log------");
        Object ret = methodInvocation.proceed();
        return false;
    }
}
