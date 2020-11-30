package com.osborn.springboot.config;

import com.osborn.springboot.bean.Department;
import com.osborn.springboot.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-15 23:20
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(jsonRedisSerializer);
        return template;
    }

    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(jsonRedisSerializer);
        return template;
    }


    //CacheManagerCustomizers可以用来定制缓存的一些规则
    //@Primary:默认使用
    @Primary
    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        //key多了前缀
        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

    @Bean
    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
        //key多了前缀
        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }


//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setUsePrefix(true);
//        List<String> cacheNames = this.cacheProperties.getCacheNames();
//        if (!cacheNames.isEmpty()) {
//            cacheManager.setCacheNames(cacheNames);
//        }
//
//        return (RedisCacheManager)this.customizerInvoker.customize(cacheManager);
//    }
}
