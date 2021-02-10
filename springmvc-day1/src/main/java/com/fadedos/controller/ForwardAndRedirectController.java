package com.fadedos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/2
 */
@Controller
@RequestMapping("/forwardAndRedirect")
public class ForwardAndRedirectController {
    /**
     * 测试forward转发
     * 默认 : controller跳转jsp页面默认就是forward跳转
     *
     * @return
     */
    @RequestMapping("/forward")
    public String testForward() {
        System.out.println("ForwardAndRedirectController.testForward");
        return "index";
    }

    /**
     * 测试 redirect跳转页面
     * redirect跳转页面: 使用springmvc提供的关键字 redirect
     * 使用语法: return "redirect:/index.jsp"      return "redirect:视图全名"
     * 注意: redirect跳转不会经过视图解析器
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String testRedirect() {
        System.out.println("ForwardAndRedirectController.testRedirect");
        return "redirect:/index.jsp";
    }

    /**
     * 测试forward 跳转到相同Controller类中不同的方法
     * 使用springmvc提供的关键字 forward:
     * 使用语法: return "forward:跳转Controller类上的@RequestMapping路径/跳转类中指定方法@RequestMapping路径"
     * @return
     */
    @RequestMapping("/test2")
    public String test2() {
        System.out.println("ForwardAndRedirectController.test2");

        return "forward:/forwardAndRedirect/forward";  //路径不变
    }


    /**
     * 测试redirect 跳转到相同Controller类中不同的方法
     * 使用springmvc提供的关键字 redirect:
     * 使用语法: return "redirect:跳转Controller类上的@RequestMapping路径/跳转类中指定方法@RequestMapping路径"
     * @return
     */
    @RequestMapping("/test3")
    public String test3() {
        System.out.println("ForwardAndRedirectController.test3");

        return "redirect:/forwardAndRedirect/forward";  //地址栏为controller forward路径   路径变化
    }

    /**
     * 测试跳转到不同Controller类中不同的方法
     * forward   和 redirect
     * forward:  redirect:
     * @return
     */
    @RequestMapping("/test4")
    public String test4() {
        System.out.println("ForwardAndRedirectController.test4");

//        return "forward:/hello/save"; //转发 不同controller类中发方法     --->路径不变
        return "redirect:/hello/save"; //重定向 不同controller类中发方法    --->路径变化


    }
}
