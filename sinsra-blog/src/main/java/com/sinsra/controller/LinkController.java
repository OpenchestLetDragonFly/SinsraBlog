package com.sinsra.controller;/*
 * ClassName: LinkController
 * Package: com.sinsra.controller
 * @Create: 2024/4/25 11:15
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.service.LinkService;
import org.springframework.data.redis.repository.configuration.RedisRepositoriesRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Resource
    LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }

}
