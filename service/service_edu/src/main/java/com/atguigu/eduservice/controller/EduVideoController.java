package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    //添加小节
    @PostMapping("addVideo")
    public Ret addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return Ret.ok();
    }

    //删除小节
    //后面这个方法需要完善：删除小节的时候，同时需要删除视频
    @DeleteMapping("deleteVideo/{id}")
    public Ret deleteVideo(@PathVariable String id){
        videoService.removeById(id);
        return Ret.ok();
    }

    //修改小节


}

