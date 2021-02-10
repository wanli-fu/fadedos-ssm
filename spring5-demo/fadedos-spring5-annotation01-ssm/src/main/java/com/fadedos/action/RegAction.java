package com.fadedos.action;

import com.fadedos.entity.User;
import com.fadedos.service.UserService;
import com.opensymphony.xwork2.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/27
 */
@Controller
@Scope("prototype")
public class RegAction implements Action {
    @Autowired
    private UserService userService;

    //<input type="text" name="user.name"/>
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    @Override
    public String execute() throws Exception {
        userService.register(user);
        return Action.SUCCESS;
    }
}
