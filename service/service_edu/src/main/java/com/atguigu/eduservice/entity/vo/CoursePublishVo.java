package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @Author: AndrewBar
 * @Date: Created in 0:08 2021/1/28
 */
@Data
public class CoursePublishVo {

    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示

}
