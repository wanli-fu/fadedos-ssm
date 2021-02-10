package com.fadedos.struts2;

import com.opensymphony.xwork2.Action;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/27
 */
public class RegAction implements Action {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userService.Register();
        return Action.SUCCESS;
    }
}
