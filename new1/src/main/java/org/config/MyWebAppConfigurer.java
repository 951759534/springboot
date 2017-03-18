package org.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.HandlerInterceptor.*;
/**
 * Created by K550jk on 2017/3/18.
 */
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("*");
        super.addInterceptors(registry);

    }

}
