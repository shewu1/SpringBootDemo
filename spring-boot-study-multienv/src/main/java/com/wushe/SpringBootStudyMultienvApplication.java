package com.wushe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Description:    spring boot多环境配置
 * 1、在 cmd 命令中指定：java -jar xxx.jar --spring.profiles.actvie=dev
 * 2、在 application.yml 中指定
 * spring:
 *   profiles:
 *     active: dev
 * @Author:         jtb
 * @UpdateUser:     jtb
 * @Param:
 * @Return:
 * @CreateDate:     2020/12/8 10:33
 * @UpdateDate:     2020/12/8 10:33
 * @tags:        1.0
 * @status:         done
 */
@SpringBootApplication
public class SpringBootStudyMultienvApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyMultienvApplication.class, args);
    }

}
