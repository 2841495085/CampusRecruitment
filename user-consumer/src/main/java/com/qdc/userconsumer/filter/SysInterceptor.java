package com.qdc.userconsumer.filter;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {
    /**
     * 进入拦截器后首先进入的方法
     * 返回false则不再继续执行
     * 返回true则继续执行
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object
                                     handler)throws Exception
    {
        System.out.println("我是拦截器：用户想要访问，但是没有登录！");
        HttpSession session=request.getSession();
        String userInfo = (String) session.getAttribute("uName");
        if(userInfo == null) {
            System.out.println("我证明用户没有登录");
            response.sendRedirect(request.getContextPath()+
                    "http://localhost:7004/user/tologin");
            return false;
        }
        System.out.println("我证明用户已经登录");
        return true;
    }
}
