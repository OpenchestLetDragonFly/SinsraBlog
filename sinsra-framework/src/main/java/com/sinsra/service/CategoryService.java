package com.sinsra.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Category;
import com.sinsra.domain.vo.CategoryVo;
import com.sinsra.domain.vo.PageVo;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2024-04-24 16:39:19
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

    //写博客-查询文章分类的接口
    List<CategoryVo> listAllCategory();

    //分页查询分类列表
    PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize);

}
