package com.osborn.springboot.service;

import com.osborn.springboot.bean.Department;
import com.osborn.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-16 6:39
 */
@CacheConfig(cacheManager = "deptCacheManager")
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    /**
     * 缓存的数据能存入redis
     * 第二次从缓存中查询就不能反序列化
     * 存的是dept的json数据，CacheManager默认使用时RedisTemplate<Object, Employee>操作redis缓存
     */

//    @Cacheable(value = {"dept"}, key = "#id")

//    @Cacheable(value = {"dept"})
//    public Department getDeptById(Integer id) {
//        System.out.println("查询部门：" + id);
//        return departmentMapper.getDeptById(id);
//    }

    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);

        Department dept = departmentMapper.getDeptById(id);
        //获取缓存
        Cache cache = deptCacheManager.getCache("dept");
        cache.put("dept:1", dept);
        return dept;
    }
}
