package com.yiyuan.imgservice.controller;


import com.yiyuan.imgservice.entity.Carimg;
import com.yiyuan.imgservice.service.CarimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
@RestController
@CrossOrigin  //解决跨域
@RequestMapping("/imgservice/carimg")
public class CarimgController {

    //注入
    @Autowired
    private CarimgService carimgService;

    //查询全部
    @GetMapping("findImg")
    public List<Carimg> findImg(){
        System.out.println("11111111111111");
       return carimgService.list(null);


    }

    //

}

