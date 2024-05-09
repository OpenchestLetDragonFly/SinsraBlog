package com.sinsra.service;/*
 * ClassName: SystemLoginService
 * Package: com.sinsra.service
 * @Create: 2024/5/8 12:18
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.User;

public interface SystemLoginService {
    //登录
    ResponseResult login(User user);

    ResponseResult logout();

}
