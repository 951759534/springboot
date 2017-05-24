package org.news.HandlerInterceptor;

import org.news.model.beans.User_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(value = 6)
public class adminInterceptor implements HandlerInterceptor {
    @Override
    @Autowired
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
         boolean flag = false;
         User_model user =(User_model)httpServletRequest.getSession().getAttribute("user");
         if(null != user){
            flag = true;
         }else{
             httpServletResponse.sendRedirect("/login");
         }
        return flag;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(httpServletResponse.getStatus() == 404){
            httpServletResponse.sendRedirect("/404");
        }else if(httpServletResponse.getStatus() == 500){
            modelAndView.setViewName("/errorpage/500");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
