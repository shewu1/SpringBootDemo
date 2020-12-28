package com.wushe.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: WuShe
 * @date: 2020/9/23 17:49
 * @version: 1.0.0
 * @modified By:
 */
//返回json格式数据 类似 @Controller+@ResponseBody
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world哦哦!";
    }
}
