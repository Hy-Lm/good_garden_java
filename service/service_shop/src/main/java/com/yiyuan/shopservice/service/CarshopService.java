package com.yiyuan.shopservice.service;

import com.yiyuan.shopservice.entity.Carshop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yiyuan.shopservice.entity.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
public interface CarshopService extends IService<Carshop> {

    Result login(Carshop carshop, String password);
}
