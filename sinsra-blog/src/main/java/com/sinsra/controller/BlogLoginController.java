package com.sinsra.controller;/*
 * ClassName: BlogLoginController
 * Package: com.sinsra.controller
 * @Create: 2024/4/26 10:57
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.User;
import com.sinsra.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {
    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在sinsra-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        return blogLoginService.login(user);
    }

}
