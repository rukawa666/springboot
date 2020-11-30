package com.osborn.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 18:55
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置登录功能，如果没有权限，则跳转到登录界面
        /**
         * 1、/login
         * 2、重定向到/login?error，表示登录失败
         * 3、更多详细规则
         * 4、默认post形式的/login代表处理登录
         */
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");

        //开启自动配置的注销功能
        /**
         * 1、访问/logout表示用户注销，清空session
         * 2.注销成功会返回 /login?logout页面
         */
        http.logout().logoutSuccessUrl("/");   //定制退出成功返回的url

        //开启记住我功能
        /**
         * 登录成功以后，将cookie发送给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录，点击注销会删除cookie
         */
        http.rememberMe().rememberMeParameter("remember");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().withUser("jordan").password("jordan").roles("VIP1", "VIP2")
                .and()
                                     .withUser("kobe").password("kobe").roles("VIP2")
                .and()
                                     .withUser("james").password("james").roles("VIP3");
    }
}
