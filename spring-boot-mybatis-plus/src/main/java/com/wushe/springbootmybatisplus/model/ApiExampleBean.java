package com.wushe.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 模拟数据
 * </p>
 *
 * @author jtb
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_example")
public class ApiExampleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String apiInfoId;

    private String method;

    private String url;

    private String requestHeader;

    private String requestBody;

    private String responseHeader;

    private String responseBody;

    private String status;

    private Integer elapsedTime;

    private String options;

    private String editor;

    private Date createTime;


}
