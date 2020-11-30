package com.steven.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-11 0:13
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Hello MyFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
