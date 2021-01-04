package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: AndrewBar
 * @Date: Created in 10:30 2020/12/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiliException extends RuntimeException {

    private Integer code;//状态码

    private String msg;//异常信息
}
