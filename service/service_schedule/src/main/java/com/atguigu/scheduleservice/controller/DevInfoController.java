package com.atguigu.scheduleservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.scheduleservice.entity.DevInfo;
import com.atguigu.scheduleservice.entity.vo.DevQuery;
import com.atguigu.scheduleservice.service.DevInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/scheduleservice/dev-info")
@CrossOrigin
public class DevInfoController {

    @Autowired
    private DevInfoService devInfoService;

    //查询设备表所有数据
    //rest风格  查询：get；添加：post；修改：put；删除：deleted；
    @ApiOperation(value = "所有设备列表")
    @GetMapping("findAll")
    public Ret findAll(){
        //调用service的方法实现查询所有的操作
        List<DevInfo> list = devInfoService.list(null);
        return Ret.ok().data("item",list);
    }

    @ApiOperation(value = "逻辑删除设备")
    @DeleteMapping("{id}")//id值需要通过路径传递
    public Ret removeDev(@ApiParam(name = "id",value = "设备id",required = true) @PathVariable String id){//获取路径中输入的id值

        boolean b = devInfoService.removeById(id);
        if (b){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //分页查询讲师的方法,通过路径传当前页和记录数
    //current 当前页
    //limit 每页记录数
    @GetMapping("pageDev/{current}/{limit}")
    public Ret pageListDev(@PathVariable long current,
                               @PathVariable long limit){

        //创建page对象
        Page<DevInfo> pageDev = new Page<>(current,limit);

        //调用方法实现分页
        //调用方法时，底层封装，把分页所有数据封装到pageteacher对象里面去
        devInfoService.page(pageDev,null);

        long total = pageDev.getTotal();
        List<DevInfo> records = pageDev.getRecords();//数据list集合

        return Ret.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页的方法
    @PostMapping("pageDevCondition/{current}/{limit}")
    public Ret pageDevCondition(@PathVariable long current, @PathVariable long limit,
                                    @RequestBody(required = false) DevQuery devQuery){
        //RequestBody会把返回的json数据封装，要用post提交,参数值可以为空

        //创建page对象
        Page<DevInfo> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<DevInfo> wrapper = new QueryWrapper<>();
        //多条件组合查询，判断条件值是否为空，如果不为空拼接条件
        String name = devQuery.getName();
        Integer level = devQuery.getLevel();
        String begin = devQuery.getBegin();
        String end = devQuery.getEnd();

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
        devInfoService.page(pageTeacher,wrapper);
        long total = pageTeacher.getTotal();
        List<DevInfo> records = pageTeacher.getRecords();//数据list集合
        return Ret.ok().data("total",total).data("rows",records);

    }

    //添加设备接口的方法
    @PostMapping("addDev")
    public Ret addDev(@RequestBody DevInfo devInfo){
        boolean save = devInfoService.save(devInfo);
        if (save){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getDev/{id}")
    public Ret getDev(@PathVariable String id){
        DevInfo devInfo = devInfoService.getById(id);
        return Ret.ok().data("dev",devInfo);
    }

    //讲师修改功能
    @PostMapping("updateDev")
    public Ret updateDev(@RequestBody DevInfo devInfo) {
        boolean flag = devInfoService.updateById(devInfo);
        if (flag) {
            return Ret.ok();
        } else {
            return Ret.errot();
        }
    }

}

