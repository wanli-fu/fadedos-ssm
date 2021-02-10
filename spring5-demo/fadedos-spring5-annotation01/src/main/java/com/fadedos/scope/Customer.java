package com.fadedos.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/28
 */
@Component
@Scope("prototype")
public class Customer {
}
