package com.yiyuan.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Car对象", description="")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车辆id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车主姓名")
    private String name;

    @ApiModelProperty(value = "车主电话")
    private String tel;

    @ApiModelProperty(value = "车牌号")
    private String idcar;

    @ApiModelProperty(value = "车辆里程")
    private String km;

    @ApiModelProperty(value = "上路时间")
    private String gotime;

    @ApiModelProperty(value = "是否默认")
    private int active;

    @ApiModelProperty(value = "车辆图片")
    private String img;

    @ApiModelProperty(value = "车型")
    private String typecar;


}
