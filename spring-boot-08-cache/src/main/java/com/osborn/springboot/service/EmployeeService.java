package com.osborn.springboot.service;

import com.osborn.springboot.bean.Employee;
import com.osborn.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-14 7:40
 */
@CacheConfig(cacheNames = "emp"/*, cacheManager = "empCacheManager"*/) //默认使用缓存管理器
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /*
    @Cacheable:将方法的运行结果进行缓存，以后再有相同的数据，直接从缓存中获取，不用调用查询
        属性：
            cacheNames/value:指定缓存组件的名字，将方法的结果放在哪个缓存中，是数组的形式，可以指定多个缓存
            key：缓存数据使用的key，默认是方法参数的值
                编写SpEl：#id，参数id的值   等同于#a0,#p0,#root.args[0]
            keyGenerator:key的生成器，可以指定key的生成器的组件id
                key/keyGenerator：二选一
            cacheManager(缓存管理器)/cacheResolver(缓存解析器):二选一
            condition：指定符合条件的情况下的缓存(condition = "#id > 0" )
            unless：否定缓存,当unless指定的条件为true，方法的返回值不会缓存，可以获取到结果在进行判断（unless = "#result == null"）
            sync： 是否使用异步模式,使用sync，则unless不支持
     */
    /*
    缓存原理：
        1、自动配置类：CacheAutoConfiguration
        2.缓存的配置类
            org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
            org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
            org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
            org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
            org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
            org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
            org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
            org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
            org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
            org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
            org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
        3.生效配置类：SimpleCacheConfiguration
        4.给容器中注册了一个CacheManager：ConcurrentMapCacheManager
        5.可以获取和创建ConcurrentMapCache类型的缓存组件，作用是将数据保存在ConcurrentMap中
     */

    /*
    运行流程：
    @Cacheable
        1.方法运行之前，先去查询Cache(缓存组件)，按照cacheNames指定的名字获取
            CacheManager获取对应的缓存，第一次获取缓存如果没有缓存会自动创建一个缓存
        2.去Cache中查找缓存的内容，使用一个key，默认就是方法的参数
            key是按照某种策略生成，默认是使用keyGenerator生成，默认使用SimpleKeyGenerator生成
                SimpleKeyGenerator生成key的默认策略：
                    如果没有参数，key = new SimpleKey();
                    如果有一个参数，key=参数的值
                    如果有多个参数，key = new SimpleKey(params...)
        3.没有查到缓存调用目标方法
        4.将目标方法返回的结果存入缓存

        @Cacheable标注的方法执行之前先来检查缓存中是否存在缓存数据，默认按照参数的值作为key去查询
        如果没有就运行方法并将结果放入缓存，以后直接从缓存中获取数据

        核心：
            1.使用CacheManager[默认ConcurrentMapCacheManager]根据名字获取Cache[ConcurrentMapCache]组件
            2.key是使用keyGenerator生成，默认是SimpleKeyGenerator
     */
//    @Cacheable(cacheNames = {"emp"}, key = "#root.methodName+'[' + #id + ']'")
//    @Cacheable(cacheNames = {"emp"}, keyGenerator = "myKeyGenerator", condition = "#a0 > 1 ", unless = "#p0 == 2")
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工") ;
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }

    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }

    /**
     * @CachePut:即调用了方法，又更新缓存
     * 修改数据库的某个数据，同步也要更新到缓存中
     */
//    @CachePut(value = "emp", key = "#result.id")
    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     *  key指定要清除的数据
     *  allEntries清除缓存中所有数据
     *  beforeInvocation = false:缓存的清除是否在方法之前执行
     *      默认代表是在方法执行之后执行
     */
//    @CacheEvict(value = {"emp"}, key = "#id")
//    @CacheEvict(value = {"emp"}, allEntries = true)
//    @CacheEvict(value = {"emp"}, beforeInvocation = true)
    @CacheEvict(beforeInvocation = true)
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp:" + id);
        employeeMapper.deleteEmp(id);
        int a = 10 / 0;
    }

    @Caching(
            cacheable = {
                    @Cacheable(/*value = {"emp"}, */key = "#lastName")
            },
            put = {
                    @CachePut(/*value = {"emp"}, */key = "#result.id"),
                    @CachePut(/*value = {"emp"}, */key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }


}
