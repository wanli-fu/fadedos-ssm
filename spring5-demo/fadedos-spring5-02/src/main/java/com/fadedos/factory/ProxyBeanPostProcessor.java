package com.fadedos.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/25
 */
public class ProxyBeanPostProcessor implements BeanPostProcessor {
    /*
            proxy.newProxyInstance();
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("------ new log -----");
                        Object ret = method.invoke(bean, args);
                        return ret;
                    }
                });
    }
}
