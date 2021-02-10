package com.fadedos.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component
@Lazy
public class Account {
    public Account() {
        System.out.println("Account.Account");
    }
}
