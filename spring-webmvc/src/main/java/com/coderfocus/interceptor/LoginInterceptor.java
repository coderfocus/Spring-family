package com.coderfocus.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @Description: 登录拦截器
* @param: 
* @return:  
* @Author: songwenjie
* @Date: 2019/9/10 
*/ 
public class LoginInterceptor implements HandlerInterceptor {

    private final String interceptor = "LoginInterceptor";

    /**
    * @Description: 前置拦截器
    * @param: [httpServletRequest, httpServletResponse, o]
    * @return: boolean
    * @Author: songwenjie
    * @Date: 2019/9/10
    */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(interceptor + " @ preHandle @" + httpServletRequest.getRequestURI());
        //放行
        return true;
    }

    /** 
    * @Description: 后置拦截器 
    * @param: [httpServletRequest, httpServletResponse, o, modelAndView]
    * @return: void 
    * @Author: songwenjie
    * @Date: 2019/9/10 
    */ 
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(interceptor + " @ postHandle @" + httpServletRequest.getRequestURI());
    }

    /** 
    * @Description: 完成后拦截器
    * @param: [httpServletRequest, httpServletResponse, o, e]
    * @return: void 
    * @Author: songwenjie
    * @Date: 2019/9/10 
    */ 
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(interceptor + " @ afterCompletion @" + httpServletRequest.getRequestURI());
    }
}
