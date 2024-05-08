package com.sinsra.controller;/*
 * ClassName: UserController
 * Package: com.sinsra.controller
 * @Create: 2024/5/6 20:00
 */

import com.sinsra.annotation.mySystemLog;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.User;
import com.sinsra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在sinsra-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    @mySystemLog(businessName = "查询个人信息")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }

    @PutMapping("userInfo")
    @mySystemLog(businessName = "更新个人信息")
    public ResponseResult  updateUserInfo(@RequestBody User user){
        //更新个人信息
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    @mySystemLog(businessName = "用户注册")
    public ResponseResult register(@RequestBody User user){
        //注册功能
        return userService.register(user);
    }
}