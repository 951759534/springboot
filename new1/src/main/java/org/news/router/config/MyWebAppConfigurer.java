package org.news.router.config;

import org.news.HandlerInterceptor.ErrorInterceptor;
import org.news.HandlerInterceptor.adminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by K550jk on 2017/3/18.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new adminInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin");
        super.addInterceptors(registry);
    }

}