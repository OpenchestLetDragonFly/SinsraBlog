package com.sinsra.controller;/*
 * ClassName: CategoryController
 * Package: com.sinsra.controller
 * @Create: 2024/4/24 16:52
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}
