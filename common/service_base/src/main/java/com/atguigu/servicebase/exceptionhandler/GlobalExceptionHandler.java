package com.atguigu.servicebase.exceptionhandler;

import com.atguigu.commonutils.Ret;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:28 2020/12/9
 */
@ControllerAdvice
@Slf4j//表示用到logback日志
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody//为了返回数据
    public Ret error(Exception e){
        e.printStackTrace();
        return Ret.errot().message("执行了全局异常处理");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//为了返回数据
    public Ret error(ArithmeticException e){
        e.printStackTrace();
        return Ret.errot().message("执行了ArithmeticException异常处理");
    }

    //自定义异常
    @ExceptionHandler(GiliException.class)
    @ResponseBody//为了返回数据
    public Ret error(GiliException e){
        log.error(e.getMessage());//把信息写进日志文件中
        e.printStackTrace();
        return Ret.errot().code(e.getCode()).message(e.getMsg());
    }
}
