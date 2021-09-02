package com.yiyuan.imgservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yiyuan"})
@MapperScan("com.yiyuan.imgservice.mapper")
@EnableDiscoveryClient //nacos注册
public class strat {
    public static void main(String[] args) {

        SpringApplication.run(strat.class, args);
    }
}
