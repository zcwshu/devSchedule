package com.atguigu.scheduleservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 维修单
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduSchedule对象", description="维修单")
public class EduSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "维修单编号")
    private String repairId;

    @ApiModelProperty(value = "设备编号")
    private String devId;

    @ApiModelProperty(value = "设备优先级")
    private String devPriority;

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "订单优先级")
    private String orderPriority;

    @ApiModelProperty(value = "维修状态")
    private String process;

    @ApiModelProperty(value = "显示排序")
    private Integer sort;

    @ApiModelProperty(value = "报修时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtSubmit;

    @ApiModelProperty(value = "接单时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtAccept;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;


}
