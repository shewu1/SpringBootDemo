package com.wushe.springbootstudytransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 15:55
 * @UpdateDate: 2020/12/8 15:55
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDo {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品库存
     */
    private Long num;
}
