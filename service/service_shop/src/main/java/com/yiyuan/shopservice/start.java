package com.yiyuan.shopservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yiyuan"})
@MapperScan("com.yiyuan.shopservice.mapper")
@EnableDiscoveryClient //nacos注册
public class start {

    public static void main(String[] args) {

        SpringApplication.run(start.class, args);
    }
}
