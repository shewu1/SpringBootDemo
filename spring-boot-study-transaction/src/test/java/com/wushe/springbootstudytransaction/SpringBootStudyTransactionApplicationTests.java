package com.wushe.springbootstudytransaction;

import com.wushe.springbootstudytransaction.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        int affectRows = orderService.startCreateOrder(1L, 1L);
    }
}
