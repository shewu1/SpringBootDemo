package com.wushe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/7 15:41
 * @UpdateDate: 2020/12/7 15:41
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Controller
public class IndexController {
    /**
     * 正常的页面 对应 /templates/index.html 页面
     * */
    @RequestMapping("/index")
    public String index(Model model){

        model.addAttribute("msg","这是一个index页面的正常消息");
        return "index";
    }

    /**
     * 抛出一个 RuntimeException 异常
     * */
    @RequestMapping("/index/err")
    public String err(){

        throw new RuntimeException("抛出一个 RuntimeException 异常");
    }

    /**
     * 抛出一个 RuntimeException 异常
     * */
    @RequestMapping("/index/matherr")
    public String matherr(Model model){

        int j=0;
        int i=0;
        i=100/j;

        return "index";
    }
}
