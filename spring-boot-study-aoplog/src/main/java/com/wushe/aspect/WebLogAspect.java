package com.wushe.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 11:45
 * @UpdateDate: 2020/12/8 11:45
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 切面
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
   // private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    @Pointcut("execution( * com.wushe.controller.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut(){}

    /**
     * 指定当前执行方法在logPointCut之前执行
     * */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        //logger.info("IP : " + IPAddressUtil.getClientIpAddress(request));
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        //loggger.info("参数 : " + joinPoint.getArgs());
    }
    /**
     * 指定在方法之后返回
     * */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        log.info("返回值 : " + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        log.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
}
