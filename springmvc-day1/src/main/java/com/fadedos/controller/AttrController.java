package com.fadedos.controller;

import com.fadedos.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/2
 */
@Controller
@RequestMapping("/attr")
public class AttrController {
    /**
     * 使用redirect跳转 数据传递
     *      传递数据两种方式  一种: 地址栏?拼接数据   二种 : session对象
     *
     * @return
     */
    @RequestMapping("/test2")
    public String test2(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.收集参数
        //2.调用业务方法 String name = "小白";
        String name = "小白";
        User user = new User("21", "小新", 8, new Date());
        User user1 = new User("11", "小白", 12, new Date());
        request.getSession().setAttribute("user",user);

        //3.流程跳转
        return "redirect:/attr.jsp?name="+ URLEncoder.encode(name,"UTF-8");
    }


    /**
     * 使用forward跳转页面 数据传递
     *  1.传递零散类型数据   2.传递对象类型数据  3.传递集合类型数据
     *
     *  使用request对象传递 数据  ===> Model 对象 底层封装就是request对象
     * @return
     */
    @RequestMapping("/test1")
    public String test1(Model model, HttpServletRequest request, HttpServletResponse response) {
        //获取session
        request.getSession();

        //1.收集参数
        //2.调用业务方法 String name = "小白";
        String name = "小白";
        User user = new User("21", "小新", 8, new Date());
        User user1 = new User("11", "小白", 12, new Date());
        List<User> users = Arrays.asList(user,user1);
//        request.setAttribute("users",users);
//        request.setAttribute("username",name);
//        request.setAttribute("user",user);
        model.addAttribute("users", users);
        model.addAttribute("username", name);
        model.addAttribute("user", user);
        //3.流程跳转
        return "attr";
    }
}
