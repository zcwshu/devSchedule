package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.GiliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2020-11-27
 */
@Api(description = "讲师管理")
@RestController//响应json数据
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    //访问地址：http://localhost:8001/eduservice/teacher/findAll
    //把service注入  controller里注入service，service里注入mapper
    @Autowired
    private EduTeacherService teacherService;

    //查询讲师表所有数据
    //rest风格  查询：get；添加：post；修改：put；删除：deleted；
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public Ret findAll(){
        //调用service的方法实现查询所有的操作
        List<EduTeacher> list = teacherService.list(null);
        return Ret.ok().data("item",list);
    }

    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")//id值需要通过路径传递
    public Ret removeTeacher(@ApiParam(name = "id",value = "讲师id",required = true) @PathVariable String id){//获取路径中输入的id值

        boolean b = teacherService.removeById(id);

        if (b){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //分页查询讲师的方法,通过路径传当前页和记录数
    //current 当前页
    //limit 每页记录数
    @GetMapping("pageTeacher/{current}/{limit}")
    public Ret pageListTeacher(@PathVariable long current,
                               @PathVariable long limit){

        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

//        try {
//            int i = 10/0;//测试全局异常处理
//        } catch (Exception e) {
//            //执行自定义异常
//            throw new GiliException(20001,"执行了自定义异常处理");
//        }

        //调用方法实现分页
        //调用方法时，底层封装，把分页所有数据封装到pageteacher对象里面去
        teacherService.page(pageTeacher,null);

        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();//数据list集合

//        Map map = new HashMap();
//        map.put("total",total);
//        map.put("rows",records);
//        return Ret.ok().data(map);

        return Ret.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public Ret pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                    @RequestBody(required = false) TeacherQuery teacherQuery){
                                    //RequestBody会把返回的json数据封装，要用post提交,参数值可以为空

        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //多条件组合查询，判断条件值是否为空，如果不为空拼接条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }

        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }

        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }

        if (!StringUtils.isEmpty(begin)){
            wrapper.le("gmt_create",end);
        }

        wrapper.orderByDesc("gmt_create");

        //调用方法实现分页查询
        teacherService.page(pageTeacher,wrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();//数据list集合
        return Ret.ok().data("total",total).data("rows",records);

    }



    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public Ret addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public Ret getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return Ret.ok().data("teacher",eduTeacher);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public Ret updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag) {
            return Ret.ok();
        } else {
            return Ret.errot();
        }
    }

}

