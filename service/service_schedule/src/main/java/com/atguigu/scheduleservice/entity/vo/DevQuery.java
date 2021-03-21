package com.atguigu.scheduleservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: AndrewBar
 * @Date: Created in 22:19 2021/3/4
 */
@Data
public class DevQuery {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "设备等级")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;

}
