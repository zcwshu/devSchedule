package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    //添加课程分类
    //获取上传过来的文件，把文件内容读取出来
    @PostMapping("addSubject")
    public Ret addSubject(MultipartFile file){
        //上传过来的excel文件
        subjectService.saveSubject(file,subjectService);

        return Ret.ok();
    }

    @GetMapping("getAllSubject")
    public Ret getAllSubject(){
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return Ret.ok().data("list",list);
    }
}

