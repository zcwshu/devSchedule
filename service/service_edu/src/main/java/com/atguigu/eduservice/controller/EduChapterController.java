package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    //课程大纲列表,根据课程id进行查询
    @GetMapping("getChapterVideo/{courseId}")
    public Ret getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return Ret.ok().data("allChapterVideo",list);//service中处理逻辑，返回定义的实体类list，数据回显
    }

    //添加章节
    @PostMapping("addChapter")
    public Ret addMapping(@RequestBody EduChapter eduChapter){
        chapterService.save(eduChapter);
        return Ret.ok();
    }

    //根据章节id查询
    @GetMapping("getChapterInfo/{chapterId}")
    public Ret getChapterInfo(@PathVariable String chapterId){
        EduChapter eduChapter = chapterService.getById(chapterId);
        return Ret.ok().data("chapter",eduChapter);
    }

    //修改章节
    @PostMapping("updateChapter")
    public Ret updateChapter(@RequestBody EduChapter eduChapter){
        chapterService.updateById(eduChapter);
        return Ret.ok();
    }

    //删除的方法
    @DeleteMapping("{chapterId}")
    public Ret deleteChapter(@PathVariable String chapterId){
        boolean flag = chapterService.deleteChapter(chapterId);
        if (flag){
            return Ret.ok();
        }
        return Ret.errot();
    }
}

