package com.sinsra.controller;/*
 * ClassName: BlogLoginController
 * Package: com.sinsra.controller
 * @Create: 2024/4/26 10:57
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.User;
import com.sinsra.enums.AppHttpCodeEnum;
import com.sinsra.exception.SystemException;
import com.sinsra.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
        if(!StringUtils.hasText(user.getUserName())){
            //提示必须传入用户名
            //throw new RuntimeException("");
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }

}
