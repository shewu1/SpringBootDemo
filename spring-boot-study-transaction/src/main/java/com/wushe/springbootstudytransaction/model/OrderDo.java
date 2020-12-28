package com.wushe.springbootstudytransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 15:56
 * @UpdateDate: 2020/12/8 15:56
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDo {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 购买数量
     */
    private Long count;
}
