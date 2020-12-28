package com.wushe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 11:39
 * @UpdateDate: 2020/12/8 11:39
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 切面
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger= LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("@annotation(com.wushe.annotation.Log)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object aroud(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        System.out.println("shshhs还是说");
        Object result = point.proceed();
        System.out.println("啦啦啦");
        long time = System.currentTimeMillis()-beginTime;
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException{

    }
}
