package com.wushe.springbootstudytransaction.service;

import com.wushe.springbootstudytransaction.mapper.GoodsDao;
import com.wushe.springbootstudytransaction.mapper.OrderDao;
import com.wushe.springbootstudytransaction.model.GoodsDo;
import com.wushe.springbootstudytransaction.model.OrderDo;
import jdk.nashorn.internal.ir.CatchNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 16:20
 * @UpdateDate: 2020/12/8 16:20
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Service
public class OrderService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    OrderService orderService;
    /**
     * @Description:   一个事务方法调用另一个事务方法时失效（原理:Spring 的声明式事务使用了代理）
     * @Author:         jtb
     * @UpdateUser:     jtb
     * @Param: [goodsId, count]
     * @Return: int
     * @CreateDate:     2020/12/8 17:05
     * @UpdateDate:     2020/12/8 17:05
     * @tags:        1.0
     * @status:         done
     */
    @Transactional // 开启事务(rollbackFor = Exception.class)
    public int startCreateOrder(Long goodsId, Long count) throws Exception {
        System.out.println("orderService="+orderService);
        //事务失效，不回滚
        return this.createOrder3(goodsId, count);
        //事务有效，可回滚,其实是使用了代理对象
        //return orderService.createOrder3(goodsId, count);
    }

    /**
     * 下单
     *
     * @param goodsId 购买商品id
     * @param count   购买商品数量
     * @return 生成订单数
     * 使用 @Transactional 时，默认只对非受检查异常回滚
     */
    //@Transactional // 实现事务
    @Transactional
    public int createOrder(Long goodsId, Long count) {

        // 锁定商品库存
        GoodsDo goods = goodsDao.selectForUpdate(goodsId);
        // 扣减库存
        Long newNum = goods.getNum() - count;
        goods.setNum(newNum);
        goodsDao.update(goods);
        // 模拟异常
        int a=1/0;
        // 生成订单
        OrderDo order = new OrderDo();
        order.setGoodsId(goodsId);
        order.setCount(count);
        int affectRows = orderDao.insert(order);
        return affectRows;
    }
    /**
     * @Description:    非受检查异常造成事务回滚
     * @Author:         jiangtb
     * @UpdateUser:     jiangtb 
     * @Param: [goodsId, count]
     * @Return: int
     * @CreateDate:     2021/1/6 16:44
     * @UpdateDate:     2021/1/6 16:44
     * @tags:        1.0
     * @status:         done
    */
    @Transactional
    public int createOrderCatchFinally(Long goodsId, Long count) throws Exception {

        try {
            // 锁定商品库存
            GoodsDo goods = goodsDao.selectForUpdate(goodsId);
            // 扣减库存
            Long newNum = goods.getNum() - count;
            goods.setNum(newNum);
            goodsDao.update(goods);
            // 模拟异常
            int a=1/0;
            // 生成订单
            OrderDo order = new OrderDo();
            order.setGoodsId(goodsId);
            order.setCount(count);
            int affectRows = orderDao.insert(order);
            return affectRows;
        }catch (Exception e){

            System.out.println(e.getMessage());
            throw new Exception("djdjdjdjdjjdjjdj");
           // return 0;
        }finally {
            System.out.println("结束~~");
        }
    }
    @Transactional
    public int createOrderTryFinally(Long goodsId, Long count) {
        try {
            // 锁定商品库存
            GoodsDo goods = goodsDao.selectForUpdate(goodsId);
            // 扣减库存
            Long newNum = goods.getNum() - count;
            goods.setNum(newNum);
            goodsDao.update(goods);
            // 模拟异常
            int a=1/0;
            // 生成订单
            OrderDo order = new OrderDo();
            order.setGoodsId(goodsId);
            order.setCount(count);
            int affectRows = orderDao.insert(order);
            return affectRows;
        }finally {
            System.out.println("结束~~");
        }

    }
    /**
     * @Description:    受检查异常不会回滚
     * @Author:         jtb
     * @UpdateUser:     jtb
     * @Param: [goodsId, count]
     * @Return: int
     * @CreateDate:     2020/12/8 16:48
     * @UpdateDate:     2020/12/8 16:48
     * @tags:        1.0
     * @status:         done
     */
    @Transactional // 实现事务
    public int createOrder2(Long goodsId, Long count) throws Exception {
        // 锁定商品库存
        GoodsDo goods = goodsDao.selectForUpdate(goodsId);
        // 扣减库存
        Long newNum = goods.getNum() - count;
        goods.setNum(newNum);
        goodsDao.update(goods);
        if (count < goods.getNum()) {
            //注意！此处为受检查的异常，就算抛出也不会回滚
            throw new Exception();
        }
        // 生成订单
        OrderDo order = new OrderDo();
        order.setGoodsId(goodsId);
        order.setCount(count);
        int affectRows = orderDao.insert(order);
        return affectRows;
    }

    /**
     * @Description:    抛出异常就回滚
     * @Author:         jtb
     * @UpdateUser:     jtb
     * @Param: [goodsId, count]
     * @Return: int
     * @CreateDate:     2020/12/8 16:48
     * @UpdateDate:     2020/12/8 16:48
     * @tags:        1.0
     * @status:         done
     */
    @Transactional(rollbackFor = Exception.class) // 抛出异常即回滚
    public int createOrder3(Long goodsId, Long count) throws Exception {
        // 锁定商品库存
        GoodsDo goods = goodsDao.selectForUpdate(goodsId);
        // 扣减库存
        Long newNum = goods.getNum() - count;
        goods.setNum(newNum);
        goodsDao.update(goods);
        if (count < goods.getNum()) {
            System.out.println("进来");
            //注意！此处为受检查的异常，就算抛出也不会回滚
            throw new Exception();
        }
        System.out.println("进来");
        // 生成订单
        OrderDo order = new OrderDo();
        order.setGoodsId(goodsId);
        order.setCount(count);
        int affectRows = orderDao.insert(order);
        return affectRows;
    }
}
