package com.wushe.springbootstudytransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wushe.springbootstudytransaction.mapper")
public class SpringBootStudyTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyTransactionApplication.class, args);
    }

}
