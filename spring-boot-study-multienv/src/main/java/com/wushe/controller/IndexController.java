package com.wushe.controller;

import com.wushe.config.MultienvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 10:45
 * @UpdateDate: 2020/12/8 10:45
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@RestController
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MultienvConfig multienvConfig;
    @RequestMapping("/")
    private String index(){
        logger.info(multienvConfig.getDemoname());
        return multienvConfig.getDemoname();
    }
}
