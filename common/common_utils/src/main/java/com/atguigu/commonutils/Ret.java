package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:19 2020/12/8
 */

@Data
public class Ret {

    @ApiModelProperty(value = "是否成功")//swagger注解
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //构造方法私有
    private Ret() { }

    //链式编程

    //成功静态方法
    public static Ret ok() {
        Ret ret = new Ret();
        ret.setSuccess(true);
        ret.setCode(ResultCode.SUCCESS);
        ret.setMessage("成功");
        return ret;
    }

    //失败静态方法
    public static Ret errot() {
        Ret ret = new Ret();
        ret.setSuccess(false);
        ret.setCode(ResultCode.ERROR);
        ret.setMessage("失败");
        return ret;
    }

    public Ret success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Ret message(String message) {
        this.setMessage(message);
        return this;
    }

    public Ret code(Integer code) {
        this.setCode(code);
        return this;

    }

    public Ret data(String key, Object value) {
        this.data.put(key, value);
        return this;

    }
    public Ret data(Map<String, Object> map) {
        this.setData(map);
        return this;

    }

}
