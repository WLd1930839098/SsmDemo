package com.bins.filter;


import com.bins.bean.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession();
        User user  = (User)session.getAttribute("user");
        String url =httpRequest.getRequestURL().toString();
        if(user==null&&url.indexOf("login.do")==-1){
            String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(contextPath+"/login.jsp");
        }else{
            filterChain.doFilter(httpRequest,httpResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
