package com.yiyuan.shopservice.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

@Data
public class InfoPage {
    private IPage<Carshop> iPage;
    private Long total;


}
