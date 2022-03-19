package com.wushe.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: LoginController
 * @description: TODO 类描述
 * @author: wushe
 * @date: 3/3/2022
 **/
@Controller
public class LoginController {

    /*@RequestMapping("login")
    public String login(){
        System.out.println("执行登录方法");
        return "redirect:main.html";
    }*/

    @RequestMapping("tomain")
    public String tomain(){
        System.out.println("登录成功方法");
        return "redirect:main.html";
    }
    @RequestMapping("toerror")
    public String toerror(){
        System.out.println("登录成功方法");
        return "redirect:error.html";
    }
}
