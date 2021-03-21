package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:42 2021/1/11
 */
@Data
public class OneSubject {
    private String id;

    private String title;

    //一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<TwoSubject>();
}
