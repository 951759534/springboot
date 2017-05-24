package org.news.HandlerInterceptor;


import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by K550jk on 2017/3/18.
 */
@Order(value = 2)
public class ErrorInterceptor implements HandlerInterceptor{
    @Override
        public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object Handler)
            throws Exception{
                return true ;
    }
        public void postHandle(HttpServletRequest req, HttpServletResponse res,Object Handler,ModelAndView modelAndView)
            throws Exception{
            if(res.getStatus() == 500){
                modelAndView.setViewName("/errorpage/500");
            }else if(res.getStatus() == 404){
                res.sendRedirect("/404");
            }
    }
        public void afterCompletion(HttpServletRequest req, HttpServletResponse res,Object Handler,
                                     Exception e)
            throws Exception{
        }


}
