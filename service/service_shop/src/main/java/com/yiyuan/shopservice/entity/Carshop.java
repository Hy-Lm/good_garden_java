package com.yiyuan.shopservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Carshop对象", description="")
public class Carshop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商店id")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "店铺名称")
    @JsonProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "店铺总评分")
    @JsonProperty(value = "score")
    private String score;

    @ApiModelProperty(value = "店铺位置")
    @JsonProperty(value = "address")
    private String address;

    @ApiModelProperty(value = "店铺距离")
    @JsonProperty(value = "space")
    private String space;

    @ApiModelProperty(value = "店铺图片")
    @JsonProperty(value = "img")
    private String img;

    @ApiModelProperty(value = "营业时间")
    @JsonProperty(value = "time")
    private String time;

    @ApiModelProperty(value = "店铺电话")
    @JsonProperty(value = "tel")
    private String tel;


    @ApiModelProperty(value = "店铺编号")
    @JsonProperty(value = "shopid")
    private String shopid;

}
