package com.wushe.springbootstudytransaction.mapper;

import com.wushe.springbootstudytransaction.model.OrderDo;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 16:06
 * @UpdateDate: 2020/12/8 16:06
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public interface OrderDao {
    /**
     * 新增订单
     */
    public int insert(OrderDo order);
}
