package com.yiyuan.shopservice.mapper;

import com.yiyuan.shopservice.entity.Carshop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
@Repository
public interface CarshopMapper extends BaseMapper<Carshop> {


    //登录
    @Select("select c.id from carshop c where c.shopid=#{shopid}")
    Long login(Carshop carshop);
}
