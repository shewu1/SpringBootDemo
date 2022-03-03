package com.wushe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 自定义全局异常处理
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/7 15:42
 * @UpdateDate: 2020/12/7 15:42
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@ControllerAdvice
public class MyExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionController.class);
    public static final String DEFAULT_ERROR_VIEW = "error";
    /**
     * 处理所有的Controller层面的异常
     * 如果这里添加 @ResponseBody 注解 表示抛出的异常以 Rest 的方式返回，这时就系统就不会指向到错误页面 /error
     * */
    @ExceptionHandler(Exception.class)
    public final ModelAndView handleAllExceptions(Exception ex, HttpServletRequest request){
        logger.error(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();

        //将异常信息设置如modelAndView
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);

        //返回ModelAndView
        return modelAndView;
    }
}
