package com.yiyuan.shopservice.service.impl;

import com.yiyuan.shopservice.entity.Carshop;
import com.yiyuan.shopservice.entity.Result;
import com.yiyuan.shopservice.mapper.CarshopMapper;
import com.yiyuan.shopservice.service.CarshopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
@Service
public class CarshopServiceImpl extends ServiceImpl<CarshopMapper, Carshop> implements CarshopService {

    @Autowired
    private CarshopMapper carshopMapper;

    //登录
    @Override
    public Result login(Carshop carshop, String password) {

        Result result = new Result();
        result.setSuccess(false);
        result.setDatail(null);

        Long login = carshopMapper.login(carshop);

        if(login != null && password.equals("123456")){
            result.setMsg("登陆成功");
            result.setSuccess(true);
            result.setDatail(carshop);


        }else{

            result.setMsg("用户名或者密码错误");
        }

        return result;
    }
}
