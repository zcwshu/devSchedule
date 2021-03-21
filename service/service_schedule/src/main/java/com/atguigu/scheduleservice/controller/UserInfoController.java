package com.atguigu.scheduleservice.controller;


import com.atguigu.commonutils.Ret;
import com.atguigu.scheduleservice.entity.DevInfo;
import com.atguigu.scheduleservice.entity.UserInfo;
import com.atguigu.scheduleservice.entity.vo.DevQuery;
import com.atguigu.scheduleservice.entity.vo.UserQuery;
import com.atguigu.scheduleservice.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.User;
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
@RequestMapping("/scheduleservice/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "所有用户列表")
    @GetMapping("findAll")
    public Ret findAll(){
        //调用service的方法实现查询所有的操作
        List<UserInfo> list = userInfoService.list(null);
        return Ret.ok().data("item",list);
    }

    @ApiOperation(value = "逻辑删除用户")
    @DeleteMapping("{id}")//id值需要通过路径传递
    public Ret removeUser(@ApiParam(name = "id",value = "用户id",required = true) @PathVariable String id){//获取路径中输入的id值

        boolean b = userInfoService.removeById(id);
        if (b){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //分页查询讲师的方法,通过路径传当前页和记录数
    //current 当前页
    //limit 每页记录数
    @GetMapping("pageUser/{current}/{limit}")
    public Ret pageListUser(@PathVariable long current,
                           @PathVariable long limit){

        //创建page对象
        Page<UserInfo> pageUser = new Page<>(current,limit);

        //调用方法实现分页
        //调用方法时，底层封装，把分页所有数据封装到pageteacher对象里面去
        userInfoService.page(pageUser,null);

        long total = pageUser.getTotal();
        List<UserInfo> records = pageUser.getRecords();//数据list集合

        return Ret.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页的方法
    @PostMapping("pageUserCondition/{current}/{limit}")
    public Ret pageUserCondition(@PathVariable long current, @PathVariable long limit,
                                @RequestBody(required = false) UserQuery userQuery){
        //RequestBody会把返回的json数据封装，要用post提交,参数值可以为空

        //创建page对象
        Page<UserInfo> pageUser = new Page<>(current,limit);

        //构建条件
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        //多条件组合查询，判断条件值是否为空，如果不为空拼接条件
        String name = userQuery.getName();
        Integer level = userQuery.getLevel();
        String begin = userQuery.getBegin();
        String end = userQuery.getEnd();

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
        userInfoService.page(pageUser,wrapper);
        long total = pageUser.getTotal();
        List<UserInfo> records = pageUser.getRecords();//数据list集合
        return Ret.ok().data("total",total).data("rows",records);

    }

    //添加用户接口的方法
    @PostMapping("addUser")
    public Ret addUser(@RequestBody UserInfo userInfo){
        boolean save = userInfoService.save(userInfo);
        if (save){
            return Ret.ok();
        }else{
            return Ret.errot();
        }
    }

    //根据用户id进行查询
    @GetMapping("getUser/{id}")
    public Ret getUser(@PathVariable String id){
        UserInfo userInfo = userInfoService.getById(id);
        return Ret.ok().data("user",userInfo);
    }

    //用户修改功能
    @PostMapping("updateUser")
    public Ret updateUser(@RequestBody UserInfo userInfo) {
        boolean flag = userInfoService.updateById(userInfo);
        if (flag) {
            return Ret.ok();
        } else {
            return Ret.errot();
        }
    }

}

