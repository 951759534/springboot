package org.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by K550jk on 2017/3/16.
 */
@SpringBootApplication
@EnableRedisHttpSession
public class Run {
        public static void main(String[] args){
            SpringApplication.run(Run.class,args);
        }
}
