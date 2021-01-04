package com.atguigu.scheduleservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.scheduleservice.entity.EduSchedule;
import com.atguigu.scheduleservice.entity.vo.ScheduleQuery;
import com.atguigu.scheduleservice.service.EduScheduleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 维修单 前端控制器
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/scheduleservice/schedule")
@CrossOrigin
public class EduScheduleController {

    //controller -> service -> mapper
    //把service注入
    @Autowired
    private EduScheduleService eduScheduleService;



    @ApiOperation(value = "所有维修单列表")
    @GetMapping("findAll")
    public Ret findAllRepair(){
        //调用service的方法实现查询所有的操作
        List<EduSchedule> list = eduScheduleService.list(null);
        return Ret.ok().data("item",list);
    }

    //分页查询讲师的方法,通过路径传当前页和记录数
    //current 当前页
    //limit 每页记录数
    @GetMapping("pageSchedule/{current}/{limit}")
    public Ret pageListSchedule(@PathVariable long current,
                               @PathVariable long limit){

        //创建page对象
        Page<EduSchedule> pageSchedule = new Page<>(current,limit);

        //调用方法实现分页
        //调用方法时，底层封装，把分页所有数据封装到pageteacher对象里面去
        eduScheduleService.page(pageSchedule,null);

        long total = pageSchedule.getTotal();
        List<EduSchedule> records = pageSchedule.getRecords();//数据list集合

        return Ret.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页的方法
    @PostMapping("pageScheduleCondition/{current}/{limit}")
    public Ret pageScheduleCondition(@PathVariable long current, @PathVariable long limit,
                                    @RequestBody(required = false) ScheduleQuery scheduleQuery){
        //RequestBody会把返回的json数据封装，要用post提交,参数值可以为空

        //创建page对象
        Page<EduSchedule> pageSchedule = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduSchedule> wrapper = new QueryWrapper<>();
        //多条件组合查询，判断条件值是否为空，如果不为空拼接条件
        String name = scheduleQuery.getDevId();
        Integer orderPri = scheduleQuery.getOrderPriority();
        Integer devPri = scheduleQuery.getDevPriority();
        String begin = scheduleQuery.getBegin();
        String end = scheduleQuery.getEnd();

        if (!StringUtils.isEmpty(name)){
            wrapper.like("dev_id",name);//like模糊查询  字符串为表中字段
        }

        if (!StringUtils.isEmpty(orderPri)){
            wrapper.eq("order_priority",orderPri);//eq ==
        }

        if (!StringUtils.isEmpty(devPri)){
            wrapper.eq("dev_priority",devPri);
        }

        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_submit",begin);//ge  大于等于
        }

        if (!StringUtils.isEmpty(begin)){
            wrapper.le("gmt_submit",end);//le   小于
        }

        wrapper.orderByDesc("gmt_submit");

        //调用方法实现分页查询
        eduScheduleService.page(pageSchedule,wrapper);
        long total = pageSchedule.getTotal();
        List<EduSchedule> records = pageSchedule.getRecords();//数据list集合
        return Ret.ok().data("total",total).data("rows",records);


    }

    //添加维修单接口的方法
    @PostMapping("addRepair")
    public Ret addRepair(@RequestBody EduSchedule eduSchedule){
        boolean save = eduScheduleService.save(eduSchedule);
        if (save){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getRepairInfo/{id}")
    public Ret getRepairInfo(@PathVariable String id){
        EduSchedule eduSchedule = eduScheduleService.getById(id);
        return Ret.ok().data("schedule",eduSchedule);
    }

    //讲师修改功能
    @PostMapping("updateRepairInfo")
    public Ret updateRepairInfo(@RequestBody EduSchedule eduSchedule) {
        boolean flag = eduScheduleService.updateById(eduSchedule);
        if (flag) {
            return Ret.ok();
        } else {
            return Ret.errot();
        }
        //return flag?Ret.ok():Ret.errot();
    }

//    public Ret schedulePlan(){
//
//    }

}

