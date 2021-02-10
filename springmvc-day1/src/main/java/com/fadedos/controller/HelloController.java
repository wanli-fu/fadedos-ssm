package com.fadedos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/2
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    /**
     *  @RequestMapping  修饰范围 用在类上 和方法上
     *          1.用在方法上: 给当前方法加入指定的请求路径
     *          2.用在类上: 给雷伤所有方法加入一个统一请求路径在方法访问之前需要加入类上@RequestMapping的路径
     * @return
     */
    @RequestMapping("/world")
    public String hello(){
        //1.收集数据

        //2.调用业务方法
        System.out.println("hello spring mvc");

        //3.处理响应
        return "index"; //页面逻辑名
    }

    @RequestMapping("/save")
    public String save(){
        //1.收集数据

        // 2. 调用业务方法
        System.out.println("HelloController.save");

        //3. 处理响应
        return "index";
    }
}
