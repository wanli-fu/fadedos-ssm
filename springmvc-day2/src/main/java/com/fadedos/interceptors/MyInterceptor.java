package com.fadedos.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:自定义拦截器
 * @author: pengcheng
 * @date: 2021/2/6
 */
public class MyInterceptor implements HandlerInterceptor {
    //执行流程
    //1.请求经过拦截器会优先进入拦截器中的preHandler方法执行preHandler方法中的内容
    //2.如果preHandler返回true 代表放行请求 如果返回值false  中断请求
    //3.如果preHandler返回值为true 会执行当前请求对应的控制器中方法
    //4.当控制器方法结束之后,会返回拦截器中执行拦截器中postHandler方法
    //5.postHandler执行完成之后响应请求,在响应请求完成后会执行afterCompletion方法


    //参数1 当前请求对象 参数2 当前请求对应的响应对象  参数3: 当前请求的控制器对应的方法对象
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        参数3: 当前请求的控制器对应的方法对象
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        System.out.println("--------1-------");

        //强制用户登录
//        Object user = request.getSession().getAttribute("user");
//        if (user == null) {
//            //跳转到登录页面  重定向
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
//            return false;
//        }
        return true;
    }

    // 参数 modelAndView   当亲请求方法控制器返回的modelAndView  模型和视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //2.是controller
        System.out.println("modelAndView = " + modelAndView);
        System.out.println("--------3-------");
    }

    //该方法无论正确或失败 都会执行
    //参数4 请求过程中出现异常时候的异常对象
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("ex = " + ex.getMessage());
        //2.是controller
        System.out.println("--------4-------");
    }
}
