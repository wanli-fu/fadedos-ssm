package com.fadedos.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.fadedos.aop..*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //额外功能
        System.out.println("-------------   aspect  log   -----------------");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
