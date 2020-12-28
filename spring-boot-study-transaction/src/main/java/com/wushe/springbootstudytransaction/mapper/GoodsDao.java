package com.wushe.springbootstudytransaction.mapper;

import com.wushe.springbootstudytransaction.model.GoodsDo;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 15:59
 * @UpdateDate: 2020/12/8 15:59
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public interface GoodsDao {
    /**
     * 查询商品信息(根据id查询单个商品信息)
     */
    public GoodsDo selectForUpdate(Long id);

    /**
     * 修改商品信息(根据id修改其他属性值)
     */
    public int update(GoodsDo Goods);
}
