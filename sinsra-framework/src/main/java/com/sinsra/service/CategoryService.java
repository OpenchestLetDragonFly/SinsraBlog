package com.sinsra.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2024-04-24 16:39:19
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
