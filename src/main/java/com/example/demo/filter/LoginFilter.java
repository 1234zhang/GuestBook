package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getSession(false)!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendRedirect("/login/login");
    }

    @Override
    public void destroy() {
    }
}
