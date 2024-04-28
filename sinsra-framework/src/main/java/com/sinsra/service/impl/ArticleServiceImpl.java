package com.sinsra.service.impl;/*
 * ClassName: ArticleServiceImpl
 * Package: com.sinsra.service.impl
 * @Create: 2024/4/23 21:43
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.constants.SystemConstants;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Article;
import com.sinsra.domain.entity.Category;
import com.sinsra.mapper.ArticleMapper;
import com.sinsra.service.ArticleService;

import com.sinsra.service.CategoryService;
import com.sinsra.util.BeanCopyUtils;
import com.sinsra.vo.ArticleDetailVo;
import com.sinsra.vo.ArticleListVo;
import com.sinsra.vo.HotArticleVo;
import com.sinsra.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    CategoryService categoryService;

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查找10条（分页）
        Page<Article> page = new Page(SystemConstants.ARTICLE_STATUS_CURRENT,SystemConstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();

        List<HotArticleVo> hotArticles = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);

        return ResponseResult.okResult(hotArticles);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper();
        //如果用户传入了类型参数
        queryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);
        queryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        queryWrapper.orderByDesc(Article::getIsTop);
        Page<Article> page = new Page(pageNum,pageSize);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();
        /*
        for (Article article : articles) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }
        */
        articles.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());

        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        PageVo pageVO = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVO);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        Article article = getById(id);
        Long categoryId = article.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if(category!=null)
            article.setCategoryName(category.getName());
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article,ArticleDetailVo.class);
        return ResponseResult.okResult(articleDetailVo);
    }
}
