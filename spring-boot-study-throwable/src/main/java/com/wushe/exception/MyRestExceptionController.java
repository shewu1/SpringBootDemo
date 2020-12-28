package com.wushe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/7 15:31
 * @UpdateDate: 2020/12/7 15:31
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 自定义异常
 */
/**
 * 基于@ControllerAdvice注解的全局异常统一处理只能针对于Controller层的异常
 * 为了和Controller 区分 ，我们可以指定 annotations = RestController.class，那么在Controller中抛出的异常 这里就不会被捕捉
 * */
@RestControllerAdvice/*(annotations = RestController.class)*/
public class MyRestExceptionController {
    private static final Logger logger= LoggerFactory.getLogger(MyRestExceptionController.class);

    /**
     * 处理所有的Controller层面的异常
     * */
    @ExceptionHandler(Exception.class)
    //@ResponseBody
    public final Map handleAllExceptions(Exception ex, WebRequest request){
        logger.error(ex.getMessage());
        Map<String,Object> map=new HashMap<>();
        map.put("status",-1);
        map.put("msg",ex.getLocalizedMessage());

        return map;
    }
}
