package com.migen.iotcloud.utils;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    protected static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static boolean IsInit(){
        if (context==null){
            return false;
        }
        return true;
    }

    public static RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate =  (RedisTemplate) context.getBean("redisTemplate");
        return redisTemplate;
    }


    public static SqlSessionTemplate getSqlSession() {
        SqlSessionTemplate sqlSession =  (SqlSessionTemplate ) SpringContext.getBean("sqlSession");
        return sqlSession;
    }
}