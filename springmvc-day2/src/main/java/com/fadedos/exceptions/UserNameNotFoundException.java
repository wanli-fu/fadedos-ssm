package com.fadedos.exceptions;

/**
 * @Description:自定义异常
 * @author: pengcheng
 * @date: 2021/2/6
 */
public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
