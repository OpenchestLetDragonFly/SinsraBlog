package com.sinsra.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.constants.SystemConstants;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Article;
import com.sinsra.domain.entity.Category;
import com.sinsra.mapper.CategoryMapper;
import com.sinsra.service.ArticleService;
import com.sinsra.service.CategoryService;
import com.sinsra.util.BeanCopyUtils;
import com.sinsra.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2024-04-24 16:39:20
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        //先找出正式发布的文章的类型号，并且去重
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> list = articleService.list(articleWrapper);
        Set<Long> categoryIds = list.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        //根据类型号，和状态，获取分类名
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());


        List<CategoryVO> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVO.class);
        return ResponseResult.okResult(categoryVos);
    }
}
