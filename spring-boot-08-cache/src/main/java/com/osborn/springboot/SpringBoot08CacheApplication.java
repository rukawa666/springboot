package com.osborn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1.导入数据库文件，创建出department和employee表
 * 2.创建javaBean封装数据库数据
 * 3.整合mybatis操作数据库
 *  a.配置数据源
 *  b.使用注解版的mybatis
 *      ①.@MapperScan指定mybatis需要扫描的包路径
 *
 *  快速体验缓存
 *     1.开启基于注解的缓存（@EnableCaching）
 *     2.标注缓存注解
 *       @Cacheable
 *       @CacheEvict
 *       @CachePut
 *
 *
 *  开发中使用的缓存中间件：redis、memcached、ehcache
 *  整合redis作为缓存
 *  redis是一个开源的，内存中的数据结构存储系统，它可以用来做数据库、缓存和消息中间件
 *  1、安装redis：使用docker
 *  2、引入redis的starter
 *  3、配置redis
 *  4、测试缓存
 *      原理：CacheManager==Cache缓存组件来实际给缓存中存取数据
 *      1)、引入redis的starter，容器中保存的是RedisCacheManager
 *      2)、RedisCacheManager创建RedisCache来作为缓存组件，RedisCache通过操作redis缓存数据
 *      3)、默认保存数据k-v都是Object，利用序列化保存
 *      4)、保存为json
 *          1.引入了redis的starter，cacheManager变为RedisCacheManager
 *          2.默认创建的RedisCacheManager操作redis的时候使用的是RedisTemplete<Object, Object>
 *          3.RedisTemplete<Object, Object>是默认使用jdk的序列化机制
 *      5)、
 */
@SpringBootApplication
@MapperScan(value = "com.osborn.springboot.mapper")
@EnableCaching
public class SpringBoot08CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08CacheApplication.class, args);
    }
}
