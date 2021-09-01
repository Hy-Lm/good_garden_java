package com.yiyuan.eduservice.config;




import org.mybatis.spring.mapper.MapperScannerConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CarConfig  implements WebMvcConfigurer {
//implements WebMvcConfigurer
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
        scannerConfigurer.setBasePackage("com.yourpackage.*.mapper");
        return scannerConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置文件已生效");
        // addResourceHandler: （ 存储图片的虚拟路径，在 static 目录下的 picture 文件夹，用于存储上传图片）
        // addResourceLocations: （ file: + 存储图片的路径）

        String path ="D:\\IDEA\\yiyuan_parent\\service\\service_car\\src\\main\\resources\\static\\images\\";
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path);
    }



}
