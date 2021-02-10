package com.fadedos.action;

import com.fadedos.entity.User;
import com.fadedos.service.UserService;
import com.opensymphony.xwork2.Action;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/27
 */
public class RegAction implements Action {
    private UserService userService;

    //<input type="text" name="user.name"/>
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userService.register(user);
        return Action.SUCCESS;
    }
}
