package com.wushe.springbootredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/14 10:50
 * @UpdateDate: 2020/12/14 10:50
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer idBgt;
    private String name;
    private Integer age;
}
