package com.atguigu.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:09 2021/1/19
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    //表示小结,,一个方案中有一个维修顺序
    private List<VideoVo> children = new ArrayList<>();
}
