package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.Ret;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:55 2020/12/15
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin//解决跨域
public class EduLoginController {

    //login
    @PostMapping("login")
    public Ret Login(){
        return Ret.ok().data("token","admin");
    }

    //info
    @GetMapping("info")
    public Ret Info(){

        return Ret.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
