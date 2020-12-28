package com.wushe.springbootmybatisplus;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * l_data
 * @author 
 */
@Data
public class LData implements Serializable {
    private String id;

    /**
     * 沙盘id 
     */
    private String sandTableId;

    /**
     * 语音数据json
     */
    private String voiceJson;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    /**
     * 1:正常 0：删除
     */
    private Byte status;

    private String masterId;

    private String name;

    /**
     *  语音类型（1: AI语音  2: 音频）
     */
    private String type;

    /**
     * 录屏初始化数据
     */
    private String recInitJson;

    /**
     * 录屏数据
     */
    private String recJson;

    /**
     * 发音设置
     */
    private String setUp;

    private static final long serialVersionUID = 1L;
}