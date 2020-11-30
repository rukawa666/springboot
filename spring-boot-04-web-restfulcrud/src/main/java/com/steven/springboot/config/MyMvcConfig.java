package com.steven.springboot.config;

import com.steven.springboot.component.LoginHandlerInterceptor;
import com.steven.springboot.component.MyLocaleResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-06 7:08
 *
 * WebMvcConfigurerAdapter可以扩展SpringMVC的功能
 * @EnableWebMvc 接管SpringMVC,使Springboot自动配置的SpringMVC都失效
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /steven 请求来到 success
        registry.addViewController("/steven").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css, *.js
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}

