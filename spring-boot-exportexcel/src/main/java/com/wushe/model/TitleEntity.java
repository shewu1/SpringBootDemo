package com.wushe.model;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 成都旺小宝科技有限公司
 * @Author: jtb
 * @CreateDate: 2020/12/14 9:32
 * @UpdateDate: 2020/12/14 9:32
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 表头实体类
 */
public class TitleEntity {
    public  String t_id;
    public  String t_pid;
    public  String t_content;
    public  String t_fielName;
    public TitleEntity(){}
    public TitleEntity(String t_id, String t_pid, String t_content, String t_fielName) {
        this.t_id = t_id;
        this.t_pid = t_pid;
        this.t_content = t_content;
        this.t_fielName = t_fielName;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_pid() {
        return t_pid;
    }

    public void setT_pid(String t_pid) {
        this.t_pid = t_pid;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_fielName() {
        return t_fielName;
    }

    public void setT_fielName(String t_fielName) {
        this.t_fielName = t_fielName;
    }

}
