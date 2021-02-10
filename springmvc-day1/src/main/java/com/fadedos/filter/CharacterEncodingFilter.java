package com.fadedos.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/2
 */
public class CharacterEncodingFilter  implements Filter {
    //作为成员变量 读到就赋值给成员变量
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //读到就赋值给成员变量
        this.encoding = filterConfig.getInitParameter("encoding");

        //输出一下 看启动时候是否可以读到
        System.out.println("encoding = " + encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
