package com.fadedos.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Configuration
@ComponentScan(basePackages = "com.fadedos.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
