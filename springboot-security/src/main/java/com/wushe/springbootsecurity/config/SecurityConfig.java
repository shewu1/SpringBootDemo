package com.wushe.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @className: SecurityConfig
 * @description: TODO 类描述
 * @author: wushe
 * @date: 3/3/2022
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPW(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单提交
                .loginProcessingUrl("/login")//登录会进入自定义登录逻辑
                .loginPage("/login.html")//登录页面
                .successForwardUrl("/tomain") // 表单方式
                .failureForwardUrl("/toerror")
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/login.html").permitAll()//不需要被认证的配置
                .antMatchers("/error.html").permitAll()
                .anyRequest()  // 所有请求
                .authenticated()// 都需要认证
                .and().csrf()
                .disable();


    }
}
