package com.steven.springboot.config;

import com.steven.springboot.filter.MyFilter;
import com.steven.springboot.listener.MyListener;
import com.steven.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-10 17:57
 */
@Configuration
public class MyServletConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean servlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/myFilter", "/hello"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean =
                new ServletListenerRegistrationBean<>(new MyListener());

        return listenerRegistrationBean;
    }
}
