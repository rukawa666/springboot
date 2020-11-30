package com.steven.springboot;

import com.steven.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot的单元测试
 *
 * 可以在测试期间很方便的类似编码一样的自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testService() {
        boolean flag = ioc.containsBean("helloWorldService");
        System.out.println(flag);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
