package com.fadedos.controller;

import com.fadedos.entity.User;
import com.fadedos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/3
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/save")
    public String  save(User user){
        //调用业务方法
        try {
            userService.save(user);
            return "redirect:/user/findAll";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/add.jsp";
        }

    }

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        //1.收集数据
        //2.调用业务对象
        List<User> users = userService.findAll();
        request.setAttribute("users",users);

        //3.流程跳转
        return "findAll";
    }
}
