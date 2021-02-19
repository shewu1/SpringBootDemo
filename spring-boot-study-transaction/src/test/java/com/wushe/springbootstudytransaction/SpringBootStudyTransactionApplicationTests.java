package com.wushe.springbootstudytransaction;

import com.wushe.springbootstudytransaction.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBootStudyTransactionApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
    }
    /**
     * 新增一个商品
     */
    @Test
    void testCreateOrder() throws Exception {
        // 购买id为1的商品1份
        //int affectRows = orderService.startCreateOrder(1L, 1L);
        //非受检异常回滚
        //int affectRows1 = orderService.createOrder(1l,1l);
        //受检异常不回滚
        //int affectRows2 = orderService.createOrder2(1l,1l);
        //try catch 事务失效
        //orderService.createOrderCatchFinally(1l,1l);
        // try finally 事务有效回滚
        //orderService.createOrderTryFinally(1l,1l);

    }
    @Test
    void TestStopWatch() throws Exception{
        StopWatch sw = new StopWatch();

        sw.start("校验耗时");
        Thread.sleep(1000);
        sw.stop();

        /*sw.start("组装报文耗时");
        Thread.sleep(2000);
        sw.stop();

        sw.start("请求耗时");
        Thread.sleep(1000);
        sw.stop();*/

        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
    }
}
