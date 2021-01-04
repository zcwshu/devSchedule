package com.atguigu.scheduleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: AndrewBar
 * @Date: Created in 18:50 2021/1/3
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
}
