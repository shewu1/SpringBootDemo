package com.wushe.controller;

import com.wushe.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 11:30
 * @UpdateDate: 2020/12/8 11:30
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 使用AOP实现日志拦截
 */
@RestController
public class IndexController {
    @Log(value ="日志注解，配合WebAspect记录请求前、请求后、请求过程" )
    @RequestMapping("/log")
    public String log(String name){
        return "log12";
    }
    @GetMapping("/log1")
    public String log1(){
        return "lllll";
    }
}
