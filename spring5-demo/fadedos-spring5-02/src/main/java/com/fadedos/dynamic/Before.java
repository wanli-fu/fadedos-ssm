package com.fadedos.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class Before implements MethodBeforeAdvice {
    /*
        作用: 需要把运行在原始方法之前运行的额外功能,书写在before方法中
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---- method before advice log ----");
    }
}
