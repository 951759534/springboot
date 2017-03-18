package org.HandlerInterceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by K550jk on 2017/3/18.
 */
public class MyInterceptor1 implements HandlerInterceptor{
    @Override
        public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object Handler)
            throws Exception{
                System.out.print(req);
                return true ;
    }
        public void postHandle(HttpServletRequest req, HttpServletResponse res,Object Handler,ModelAndView modelAndView)
            throws Exception{
            System.out.print(req);
    }
        public void afterCompletion(HttpServletRequest req, HttpServletResponse res,Object Handler,
                                     Exception e)
            throws Exception{
            System.out.print(req);
        }


}
