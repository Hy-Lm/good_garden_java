package com.yiyuan.shopservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yiyuan"})
@MapperScan("com.yiyuan.shopservice.mapper")
public class start {

    public static void main(String[] args) {

        SpringApplication.run(start.class, args);
    }
}
