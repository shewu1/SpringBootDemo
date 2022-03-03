package com.wushe.springbootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @className: userDetailsImpl
 * @description: TODO 自定义登录逻辑
 * @author: wushe
 * @date: 3/3/2022
 **/
@Service
public class userDetailsImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pwencoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        String pwd = pwencoder.encode("123");
        System.out.println("进来");
        return new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
