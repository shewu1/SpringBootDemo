package com.wushe.springbootmybatisplus.controller;

import com.wushe.springbootmybatisplus.model.ApiExampleBean;
import com.wushe.springbootmybatisplus.service.ApiExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/14 17:02
 * @UpdateDate: 2020/12/14 17:02
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@RestController
@RequestMapping("/api")
public class ApiExampleController {
    @Autowired
    private ApiExampleService apiExampleService;
    @GetMapping("selectById")
    public ApiExampleBean selectById(){
        ApiExampleBean apiExampleBean = apiExampleService.getBaseMapper().selectById("5fca09ad602e877ea4abad2f");
        System.out.println(apiExampleBean.toString());
        return apiExampleBean;
    }
}
