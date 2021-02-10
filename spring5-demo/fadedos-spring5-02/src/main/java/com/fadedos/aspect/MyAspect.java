package com.fadedos.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/25
 */


/*
        1. 额外功能
            public class MyAround implements MethodInterceptor {
                public Object invoke(MethodInvocation invocation) {
                        //引入额外功能
                        Object ret = invocation.proceed();
                        //引入额外功能
                        return ret;
                }
            }

        2. 切入点
                <aop:config>
                    <!--所有的方法,都作为切入点,加入额外功能 login register-->
                    <aop:pointcut id="pc" expression="execution(* login(..)) "/>

                    <!--组装: 目的把切入点与额外功能 进行整合-->
                    <aop:advisor advice-ref="around" pointcut-ref="pc"/>
                </aop:config>
 */
@Aspect //切面类
public class MyAspect {

    //切入点复用
    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPoint() {

    }

    //1. 额外功能
    // 2. 切入点 @Around(切入点表达式)
    @Around(value = "myPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----- aspect log -----");
        Object ret = joinPoint.proceed();
        return ret;
    }


    @Around(value = "myPoint()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----- aspect tx -----");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
