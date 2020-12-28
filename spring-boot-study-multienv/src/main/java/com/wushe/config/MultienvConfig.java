package com.wushe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/8 10:40
 * @UpdateDate: 2020/12/8 10:40
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 配置文件
 */
@Component
/**
*从配置文件中获取属性值
*/
@ConfigurationProperties(prefix = "springstudy")
public class MultienvConfig {
    private String demoname;
    public String getDemoname() {
        return demoname;
    }

    public void setDemoname(String demoname) {
        this.demoname = demoname;
    }
}
