package com.atguigu.scheduleservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:00 2021/1/3
 */
@Data
public class ScheduleQuery {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备名称,模糊查询")
    private String devId;

    @ApiModelProperty(value = "订单优先级 1 2")
    private Integer orderPriority;

    @ApiModelProperty(value = "设备优先级 1 2")
    private Integer devPriority;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;

}
