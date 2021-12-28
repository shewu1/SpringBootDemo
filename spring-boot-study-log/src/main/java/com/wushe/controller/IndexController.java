package com.wushe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 9:28
 * @UpdateDate: 2020/12/8 9:28
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 日志测试-springboot默认的日志是使用logback
 */
/**
* 当我们把 xml 文件同 application.yml 都进行配置的时候
 * ，他执行了 logback-spring.xml 中的配置，所以 logback-spring.xml 配置是优先的
* */
@RestController
@Slf4j
public class IndexController {
    // private final Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/")
    public String index(){

        log.debug("This is a debug message");
        log.info("This is an {} message","info");
        log.warn("This is a warn message");
        log.error("This is an {} message {}","er","blue");
        return "index";
    }
}
