package com.fadedos.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/20
 */
public class Product implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Product.setName");
        this.name = name;
    }

    public Product() {
        System.out.println("Product.Product");
    }

    //这个就是初始化方法: 做一些初始化操作
    //spring会自动进行调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }


    //初始化方法
    public void myInit() {
        System.out.println("Product.myInit");
    }

    //销毁方法: 销毁操作(资源释放操作)
    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    //自定义销毁方法
    public void myDestroy() throws Exception {
        System.out.println("Product.myDestroy");
    }
}
