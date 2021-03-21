package com.atguigu.scheduleservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @author AndrewBar
 * @since 2021-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RepairInfo对象", description="")
public class RepairInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "设备编号")
    private String devId;

    @ApiModelProperty(value = "设备优先级")
    private Integer priority;

    @ApiModelProperty(value = "报修时间")
    private Date gmtSubmit;

    @ApiModelProperty(value = "报修人")
    private String submitName;

    @ApiModelProperty(value = "问题描述")
    private String problem;

    @ApiModelProperty(value = "所属订单")
    private String order;

    @ApiModelProperty(value = "订单优先级")
    private Integer orderPriority;

    @ApiModelProperty(value = "维修人")
    private String repairName;

    @ApiModelProperty(value = "验收人")
    private String commitName;

    @ApiModelProperty(value = "维修结果")
    private String result;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    @ApiModelProperty(value = "开始时间")
    private Date gmtBegin;

    @ApiModelProperty(value = "结束时间")
    private Date gmtEnd;

    @ApiModelProperty(value = "维修进度")
    private String process;

    @ApiModelProperty(value = "维修耗时")
    private String repairTime;


}
