package com.sinsra.service;/*
 * ClassName: BlogLoginService
 * Package: com.sinsra.service
 * @Create: 2024/4/26 11:03
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}

