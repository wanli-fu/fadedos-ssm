package com.fadedos.controller;

import com.alibaba.fastjson.JSONObject;
import com.fadedos.entity.User;
import com.fadedos.exceptions.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/6
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("----2----");
//        throw new RuntimeException("测试异常");
        throw new UserNameNotFoundException("用户名木有发现"); //自定义异常
//        return "index";
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public List<User> showAll() {
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(), "小陈", 23, new Date()));
        users.add(new User(UUID.randomUUID().toString(), "小李", 25, new Date()));
        users.add(new User(UUID.randomUUID().toString(), "小张", 33, new Date()));

        return users;
    }

    /**
     * 使用fastjson 转换json
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/findAll")
    public void findAll(HttpServletResponse response) throws IOException {
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(), "小陈", 23, new Date()));
        users.add(new User(UUID.randomUUID().toString(), "小李", 25, new Date()));
        users.add(new User(UUID.randomUUID().toString(), "小张", 33, new Date()));

        //fastjson
        String s = JSONObject.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
    }
}
