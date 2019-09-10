package com.coderfocus.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllInterceptor implements HandlerInterceptor {

    private final String interceptor = "AllInterceptor";

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(interceptor + " @ preHandle @" + httpServletRequest.getRequestURI());
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(interceptor + " @ postHandle @" + httpServletRequest.getRequestURI());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(interceptor + " @ afterCompletion @" + httpServletRequest.getRequestURI());
    }
}
